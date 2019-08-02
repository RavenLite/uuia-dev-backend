package uuia.info.devbackend.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author raven
 */
public class MailUtil {
    // 发件人 账号和密码
    public static final String MY_EMAIL_ACCOUNT = "uuia_info@163.com";
    public static final String MY_EMAIL_PASSWORD = "vvjb3120";

    // 163邮箱 SMTP 服务器地址及端口
    public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
    public static final String SMTP_163_PORT = "25";

    public static void send(String email, String code) throws AddressException, MessagingException {
        System.out.println("[INFO]" + email + "\n" + code);
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
        p.setProperty("mail.smtp.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
            }
        });
        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
        // 收件人和抄送人
        message.setRecipients(Message.RecipientType.TO, email);
        // 内容
        String content = "<html><head></head><body><h1>欢迎注册UUIA</br>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8893/activation?code="
                + code + "'>http://localhost:8893/activation?code=" + code
                + "</href></h3></body></html>";
        message.setSubject("UUIA账号激活");
        message.setContent(content, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        Transport.send(message);
    }
}
