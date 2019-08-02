package uuia.info.devbackend.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.RelationUserApp;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.RelationUserAppRepository;
import uuia.info.devbackend.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    @Autowired
    AppRepository appRepository;

    @Autowired
    RelationUserAppRepository relationUserAppRepository;

    @Autowired
    UserRepository userRepository;

    public boolean register(User user){
        if(checkUserVaild(user)){
            userRepository.save(user);
        }
        else {
            return false;
        }
        return true;
    }

    public String login(User user){
        User standardUser;
        if(user.getMail()!= null){
            standardUser = userRepository.findByMail(user.getMail());
        }else if(user.getPhone() != null){
            standardUser = userRepository.findByPhone(user.getPhone());
        }else if(user.getUsername() != null){
            standardUser = userRepository.findByUsername(user.getUsername());
        }else {
            return "用户名无效";
        }

        if(standardUser != null){
            if(user.getPassword().equals(standardUser.getPassword())){
                return "登录成功";
            }else {
                return "密码不正确";
            }
        }
        return "用户名不存在";

    }

    public User getUserInfo(User user){
        if(user.getMail()!= null){
            return userRepository.findByMail(user.getMail());
        }else if(user.getPhone() != null){
            return userRepository.findByPhone(user.getPhone());
        }else if(user.getUsername() != null){
            return userRepository.findByUsername(user.getUsername());
        }else {
            return null;
        }
    }


    public JSONObject getUserAllApps(int userId){
        JSONObject appList = new JSONObject();
        List<App> appList1 = appRepository.findAllByOwnerId(userId);
        List<App> appList2 = new ArrayList<>();
        List<RelationUserApp> relationUserAppList = relationUserAppRepository.findAllByUserId(userId);
        for (RelationUserApp relationUserApp: relationUserAppList) {
            appList2.add(appRepository.findById(relationUserApp.getId()));
        }
        appList.put("own",appList1);
        appList.put("other",appList2);
        return appList;
    }

    public boolean createApp(App app){
        if(checkUserVaild(app)){
            appRepository.save(app);
        }
        else {
            return false;
        }
        return true;
    }


    public boolean updateApp(App app){
        if(checkUserVaild(app)){
            appRepository.save(app);
        }else {
            return false;
        }
        return true;
    }

    public App getAppDetail(int appID){
        return appRepository.findById(appID);
    }













    public static boolean checkUserVaild(User user){
        return true;
    }
    public static boolean checkUserVaild(App app){

        return true;
    }


}
