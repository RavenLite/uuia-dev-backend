package uuia.info.devbackend.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class UUIAMailSender {

    private final static String FROM_EMAIL_ADDRESS = "uuia@cheelem.com";
    private final static String HOST = "smtp.qiye.aliyun.com";
    private final static String USERNAME = "uuia@cheelem.com";
    private final static String PASSWORD = "iamUUIAmailer#1";
    private final static int PORT = 465;
    private static JavaMailSenderImpl mailSender = null;

    public static void init() {
        mailSender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", String.valueOf(PORT));
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(properties);
        mailSender.setUsername(USERNAME);
        mailSender.setPassword(PASSWORD);
        mailSender.setPort(PORT);
        mailSender.setHost(HOST);
    }

    private static synchronized void sendHTMLMessage(String toEmailAddress, String subject, String htmlCodeContent) {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true, "utf-8");
            helper.setFrom(FROM_EMAIL_ADDRESS);//发件人
            helper.setTo(toEmailAddress);//收件人
            helper.setSubject(subject);//邮件标题
            helper.setText(htmlCodeContent, true); //测试内容（html）
            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void sendTextMessage(String toEmailAddress, String subject, String content) {
        if (mailSender == null) {
            init();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL_ADDRESS);
        message.setTo(toEmailAddress);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    public static void sendRegisterActivationCodeMail(String toEmail, String personRealName, String code) {
        if (mailSender == null) {
            init();
        }
        UUIAMailTemplate template = new UUIAMailTemplate();
        template.setHeading("尊敬的 " + personRealName + " 阁下：");
        template.setTitle("UUIA 开发者平台 激活验证");
        template.setContent("非常感谢您注册 UUIA 开发者平台账户。在使用之前您需要进行邮箱验证以激活您的账户。请点击下方链接完成激活。");
        template.setButtonText("https://neuvwo.com:8893/activation?code=" + code);
        template.setButtonLink("#");
        sendHTMLMessage(toEmail, "UUIA 开发者平台 账户激活", template.compile());
    }
}

