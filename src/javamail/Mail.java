package javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Mail {

	public static void main(String[] args) {
		Properties prop = new Properties() ;
		prop.put("mail.smtp.auth", "true") ;
	    prop.put("mail.smtp.host", "smtp.163.com") ;
		MailAuthenticator authenticator = new MailAuthenticator("hshalarm@163.com" , "etone12345") ;
		Session session = Session.getInstance(prop, authenticator) ;
		Message message = new MimeMessage(session) ;
		try {
			message.setFrom(new InternetAddress("hshalarm@163.com")) ;
			message.setRecipient(RecipientType.TO, new InternetAddress("417246485@qq.com")) ;
			message.setText("¸ç!!") ;
			message.setSubject("¸ç!!") ;
			Transport.send(message) ;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
