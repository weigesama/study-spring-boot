package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	private String from = "weigesama@qq.com";
	private String to = "weigesama@qq.com";


	@Autowired
	private JavaMailSender mailSender;

//	@Autowired
//	private VelocityEngine velocityEngine; // gg，sb1.5.2后就不再支持velocity了

	@Test
	public void sendSimpleMail() throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		mailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addInline("weixin", file);

		mailSender.send(mimeMessage);
	}

//	@Test
//	public void sendTemplateMail() throws Exception {
//
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//		helper.setFrom(from);
//		helper.setTo(to);
//		helper.setSubject("主题：模板邮件");
//
//		Map<String, Object> model = new HashedMap();
//		model.put("username", "didi");
//		String text = VelocityEngineUtils.mergeTemplateIntoString(
//				velocityEngine, "template.vm", "UTF-8", model);
//		helper.setText(text, true);
//
//		mailSender.send(mimeMessage);
//	}

}
