package uuia.info.devbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.UserRepository;
import uuia.info.devbackend.service.TestService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATests {

    @Autowired(required = true)
    private AppRepository appRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testJpa(){
        User user = new User();
        user.setUsername("username");
        user.setIdNumber("131182199712011111");
        user.setMail("9765@qq.com");
        user.setSchool("东北大学");
        user.setPhone("15840589320");
        user.setComment("  comment ");
        userRepository.save(user);



    }
}
