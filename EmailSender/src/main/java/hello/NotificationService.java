package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import domain.User;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	NotificationService(JavaMailSender jms) {
		this.javaMailSender = jms;
	}
	
	public void sendNotification(User user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("snblessing@gmail.com");
		mail.setSubject("testing sending emails");
		mail.setText("whassuup???");
		javaMailSender.send(mail);
	}
}
