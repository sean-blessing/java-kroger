package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.User;

@RestController
public class RegistrationController {
	
	@Autowired
	private NotificationService notificationSvc;

	@RequestMapping("/signup")
	public String signup() {
		return "Please signup for our service.";
	}
	
	@RequestMapping("/signup-success")
	public String signupSuccess() {
		User user = new User();
		user.setEmailAddress("snblessing@gmail.com");
		user.setFirstName("Sean");
		user.setLastName("Blessing");
		
		try {
			notificationSvc.sendNotification(user);
		}
		catch(MailException me) {
			System.out.println(me);
		}
		return "Thanks for registering with us.";
	}
}
