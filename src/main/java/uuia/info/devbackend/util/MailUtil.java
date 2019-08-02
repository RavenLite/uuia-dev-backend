package uuia.info.devbackend.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil implements Runnable {
	// 收件人邮箱
	private String email;
	// 激活码
	private String code;

	public MailUtil(String email, String code) {
		this.email = email;
		this.code = code;
	}

	public void run() {
		// 发件人电子邮箱
		String from = "uuia_info@163.com";
		// 指定发送邮件的主机
		String host = "smtp.163.com";
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		// 打开认证
		properties.setProperty("mail.smtp.auth", "true");

		try {
			// 1.获取默认session对象
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
				    // 发件人邮箱账号、授权码
				    return new PasswordAuthentication("uuia_info@163.com", "vvjb3120");
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("UUIA账号激活");
			// 2.4设置邮件内容
			String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8893/activation?code="
					+ code + "'>http://localhost:8893/activation?code=" + code
					+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.发送邮件
			Transport.send(message);
			System.out.println("邮件成功发送!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
