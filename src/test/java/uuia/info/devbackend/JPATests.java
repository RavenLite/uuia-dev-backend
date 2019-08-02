package uuia.info.devbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.UserRepository;
import uuia.info.devbackend.service.TestService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATests {

    @Autowired
    private TestService testService;

//    @Test
//    public void testRegister(){
//        User user = new User();
//        user.setUsername("username");
//        user.setIdNumber("131182199712011111");
//        user.setMail("9765@qq.com");
//        user.setSchool("东北大学");
//        user.setPhone("15840589320");
//        user.setComment("  comment ");
//        user.setPassword("mypass");
//        user.setName("wp");
//        testService.register(user);
//    }
//
//    @Test
//    public void testLoginByUsername(){
//        User user = new User();
//        user.setUsername("username");
//        user.setPassword("mypass");
//        System.out.println(testService.login(user));
//    }
//    @Test
//    public void testLoginByMail(){
//        User user = new User();
//        user.setMail("9765@qq.com");
//        user.setPassword("mypass");
//        System.out.println(testService.login(user));
//    }
//
//    @Test
//    public void testLoginByPhone(){
//        User user = new User();
//        user.setPhone("15840589320");
//        user.setPassword("mypass");
//        System.out.println(testService.login(user));
//    }
//
//    @Test
//    public void testGetUserInfo(){
//        User user = new User();
//        user.setPhone("15840589320");
//        System.out.println(testService.getUserInfo(user).getUsername());
//    }
//
//    @Test
//    public void testGetAllApps(){
//        System.out.println(testService.getUserAllApps(1));
//    }
//
//    @Test
//    public void testCreateApp(){
//        App app = new App();
//        app.setName("东大子节点");
//        app.setSecretKey("lasjflasjifels");
//        app.setStatus(2);
//        app.setWechatAppid("djksfojfi");
//        app.setWechatAppSecret("dlsjfioe");
//        app.setOwnerId(1);
//        app.setUrl("htt;fjdsoief");
//        testService.createApp(app);
//
//        app.setName("东大二代子节点");
//        app.setId(1);
//        testService.updateApp(app);
//    }
//
//    @Test
//    public void testGetAppDetail(){
//        System.out.println(testService.getAppDetail(1).getName());
//    }
}
