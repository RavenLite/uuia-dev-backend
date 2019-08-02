package uuia.info.devbackend.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.RelationUserApp;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.RelationUserAppRepository;
import uuia.info.devbackend.repository.UserRepository;
import uuia.info.devbackend.util.CodeUtil;
import uuia.info.devbackend.util.CommonResult;
import uuia.info.devbackend.util.MailUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static uuia.info.devbackend.util.ResultCode.E_701;

/**
 * @author raven, penapple
 */
@Service
public class TestService {
    @Resource
    AppRepository appRepository;

    @Resource
    RelationUserAppRepository relationUserAppRepository;

    @Resource
    UserRepository userRepository;

    /**
     * 注册
     */
    public CommonResult<Object> register(User user) {
        // 验证各字段是否为空
        if (!checkUserVaild(user)) {
            return CommonResult.fail(E_701);
        }
        //生成激活码
        String code = CodeUtil.generateUniqueCode();
        user.setCode(code);
        user.setState(0);
        user.setCreateTime(new Date());

        // 将用户保存到数据库
        userRepository.save(user);

        // 通过线程的方式给用户发送一封邮件
        new Thread(new MailUtil(user.getMail(), code)).start();

        return CommonResult.success("注册");
    }

    /**
     * 激活
     */
    public CommonResult<String> activation(String code) {
        User user = userRepository.findByCode(code);
        user.setState(1);
        userRepository.save(user);
        return CommonResult.success("激活");
    }

    /**
     * 登录
     */
    public String login(User user) {
        user.setLastLogin(new Date());
        User standardUser;
        if (user.getMail() != null) {
            standardUser = userRepository.findByMail(user.getMail());
        } else if (user.getPhone() != null) {
            standardUser = userRepository.findByPhone(user.getPhone());
        } else if (user.getUsername() != null) {
            standardUser = userRepository.findByUsername(user.getUsername());
        } else {
            return "用户名无效";
        }

        if (standardUser != null) {
            if (user.getPassword().equals(standardUser.getPassword())) {
                return "登录成功";
            } else {
                return "密码不正确";
            }
        }
        return "用户名不存在";

    }

    /**
     * 获取用户基本信息
     */
    public User getUserInfo(int userId) {
        return userRepository.findById(userId);
    }

    /**
     * 获取用户所有的APP子节点信息
     */
    public JSONObject getUserAllApps(int userId) {
        JSONObject appList = new JSONObject();
        List<App> appList1 = appRepository.findAllByOwnerId(userId);
        List<App> appList2 = new ArrayList<>();
        List<RelationUserApp> relationUserAppList = relationUserAppRepository.findAllByUserId(userId);
        for (RelationUserApp relationUserApp : relationUserAppList) {
            appList2.add(appRepository.findById(relationUserApp.getId()));
        }
        appList.put("own", appList1);
        appList.put("other", appList2);
        return appList;
    }

    /**
     * 新建子节点
     */
    public boolean createApp(App app) {
        if (checkAppVaild(app)) {
            appRepository.save(app);
        } else {
            return false;
        }
        return true;
    }

    /**
     * 修改子节点信息
     */
    public boolean updateApp(App app) {
        if (checkAppVaild(app)) {
            appRepository.save(app);
        } else {
            return false;
        }
        return true;
    }

    /**
     * 查看子节点详情
     */
    public App getAppDetail(String appID) {
        return appRepository.findByUuiaAppId(appID);
    }

    /**
     * 校验
     */
    private static boolean checkUserVaild(User user) {
        return user.getMail() != null && user.getPassword() != null && user.getUsername() != null && user.getPhone() != null;
    }

    private static boolean checkAppVaild(App app) {
        if (app.getName() == null || app.getOwnerId() == 0 || app.getSecretKey() == null) {
            return false;
        }

        return (app.getWechatAppid() != null && app.getWechatAppSecret() != null) || (app.getQqAppid() != null && app.getQqAppSecret() != null);
    }

}
