package uuia.info.devbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uuia.info.devbackend.util.CodeUtil;
import uuia.info.devbackend.util.MailUtil;

public class DevBackendApplicationTests {

    @Test
    public void sendEmail() {
        String code = CodeUtil.generateUniqueCode();
        System.out.println(code);
        new Thread(new MailUtil("xrwgood@qq.com", code)).start();
    }

}
