package sis.com.email;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSendDemo {

	public static void main(String[] args) {
		final String username = "babluagrahari007@gmail.com";
		final String password = "9565072546";
		System.out.println("read password");
		 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		System.out.println("message sending....");

  Session email_session = Session.getInstance(props,
  new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
  });
		
	

try {

	Message message = new MimeMessage(email_session);
	message.setFrom(new InternetAddress(username));
	
	message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("babluagrahari07@gmail.com"));
	message.setSubject("OTP"+ Math.random());
	message.setText("success is sure "+new Date());

	Transport.send(message);

	System.out.println("message sent ");

} catch (MessagingException e) {

	System.err.print(e.getMessage());
	e.printStackTrace();
}	


		
	}

}
