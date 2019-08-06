package uuia.info.devbackend.service;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.springframework.stereotype.Service;
import uuia.info.devbackend.component.IDGenerator;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.RelationUserApp;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.RelationUserAppRepository;
import uuia.info.devbackend.repository.UserRepository;
import uuia.info.devbackend.util.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static uuia.info.devbackend.util.ResultCode.*;

/**
 * @author raven, penapple
 */
@Service
public class DevOpenPlatformService {
    @Resource
    AppRepository appRepository;

    @Resource
    RelationUserAppRepository relationUserAppRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    TransmitService transmitService;

    /**
     * 注册
     */
    public CommonResult<Object> register(User user) {
        // 验证各字段是否为空
        if (!checkUserVaild(user)) {
            return CommonResult.fail(E_701);
        }

        // 检验username是否存在
        try {
            if(userRepository.findByUsername(user.getUsername()).getUsername().equals(user.getUsername())) {
                return CommonResult.fail(E_706);
            }
        } catch (NullPointerException ignored) {

        }


        // 生成激活码
        String code = CodeUtil.generateUniqueCode();
        user.setCode(code);
        user.setState(0);
        user.setCreateTime(new Date());

        // 将用户保存到数据库
        userRepository.save(user);

        // 通过线程的方式给用户发送一封邮件
        UUIAMailSender.sendRegisterActivationCodeMail(user.getMail(), user.getUsername(), code);
//            MailUtil.send(user.getMail(), code);

        return CommonResult.success("注册");
    }

    /**
     * 激活
     */
    public CommonResult<String> activation(String code) {
        User user = userRepository.findByCode(code);
        user.setState(1);
        userRepository.save(user);
        return CommonResult.success("激活成功，请返回登录");
    }

    /**
     * 登录
     */
    public CommonResult<Object> login(User user) {
        User standardUser;

        if (user.getMail() != null) {
            standardUser = userRepository.findByMail(user.getMail());
            standardUser.setLastLogin(new Date());
            userRepository.save(standardUser);
        } else if (user.getPhone() != null) {
            standardUser = userRepository.findByPhone(user.getPhone());
            standardUser.setLastLogin(new Date());
            userRepository.save(standardUser);
        } else if (user.getUsername() != null) {
            standardUser = userRepository.findByUsername(user.getUsername());
            standardUser.setLastLogin(new Date());
            userRepository.save(standardUser);
        } else {
            return CommonResult.fail(E_702);
        }

        if (user.getPassword().equals(standardUser.getPassword())) {
            JSONObject result = new JSONObject();
            String token = JwtUtil.getToken(String.valueOf(standardUser.getId()));
            result.put("token", token);
            result.put("userId", standardUser.getId());
            return CommonResult.success(result);

        } else {
            return CommonResult.fail(E_703);
        }
    }

    /**
     * 获取用户基本信息
     */
    public CommonResult<User> getUserInfo(int userId) {
        return CommonResult.success(userRepository.findById(userId), "获取用户基本信息");
    }

    /**
     * 获取用户所有的APP子节点信息
     */
    public CommonResult<JSONObject> getUserAllApps(int userId) {
        JSONObject appList = new JSONObject();
        List<App> appList1 = appRepository.findAllByOwnerId(userId);
        List<App> appList2 = new ArrayList<>();
        List<RelationUserApp> relationUserAppList = relationUserAppRepository.findAllByUserId(userId);

        for (RelationUserApp relationUserApp : relationUserAppList) {
            appList2.add(appRepository.findById(relationUserApp.getId()));
        }

        appList.put("own", appList1);
        appList.put("other", appList2);

        return CommonResult.success(appList, "获取用户所有的APP子节点信息");
    }

    /**
     * 新建子节点
     */
    public CommonResult<Object> createApp(App app, int userId) {
        String validationKeyDev;
        String uuiaAppId;
        if (checkAppVaild(app)) {
            // 生成uuiaAppId
            uuiaAppId = IDGenerator.generateAppId(new Date());
            app.setUuiaAppId(uuiaAppId);

            // secretKey明文(开发者存储)
            String secretKeyDev = app.getSecretKey();
            // secretKey密文(中心存储)
            String secretKey = sha256(secretKeyDev + System.currentTimeMillis());
            app.setSecretKey(secretKey);

            // validationKey明文(中心存储)
            String validationKey = sha256(uuiaAppId + app.getName() + System.currentTimeMillis());
            app.setValidationKey(validationKey);
            // validationKey密文(开发者存储)
            validationKeyDev = sha256(validationKey + System.currentTimeMillis());

            // 创建app
            app.setOwnerId(userId);
            app.setStatus(1);
            appRepository.save(app);

            // 创建关系
            RelationUserApp relationUserApp = new RelationUserApp();
            relationUserApp.setAppId(app.getId());
            relationUserApp.setUserId(app.getOwnerId());
            relationUserApp.setAuthority(1);
            relationUserAppRepository.save(relationUserApp);

            // 发送子节点信息与中央节点同步
            updateCenter(app);

        } else {
            return CommonResult.fail(E_701);
        }

        JSONObject result = new JSONObject();
        result.put("validationKeyDev", validationKeyDev);
        result.put("uuiaAppId", uuiaAppId);
        return CommonResult.success(result);
    }

    private String sha256(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(str.getBytes());
            return toHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String toHex(byte[] bytes) {
        StringBuilder str = new StringBuilder();
        for (byte b : bytes) {
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] temp = new char[2];
            temp[0] = chars[(b >>> 4) & 0x0F];
            temp[1] = chars[b & 0x0F];

            str.append(new String(temp));
        }
        return str.toString();
    }

    /**
     * 修改子节点信息
     */
    public CommonResult<Object> updateApp(App app) {
        if(app.getId()==0){
            return CommonResult.fail(E_701);
        }

        if (checkAppVaild(app)) {
            appRepository.save(app);
        } else {
            return CommonResult.fail(E_701);
        }

        // 与中央节点同步
        updateCenter(app);

        return CommonResult.success("修改子节点");
    }

    private void updateCenter(App app) {
        transmitService.subNode(app);
    }

    /**
     * 查看子节点详情
     */
    public CommonResult<App> getAppDetail(int appID) {
        return CommonResult.success(appRepository.findById(appID), "查看子节点详情");
    }

    /**
     * 校验
     */
    private static boolean checkUserVaild(User user) {
        return user.getMail() != null && user.getPassword() != null && user.getUsername() != null && user.getPhone() != null;
    }

    private static boolean checkAppVaild(App app) {
        return app.getName() != null;
    }

}
