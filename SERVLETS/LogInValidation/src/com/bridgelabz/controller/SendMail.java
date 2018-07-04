package com.bridgelabz.controller;

import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bridgelabz.dao.DataAccessObject;

public class SendMail {

	public static void send(String email, String adminEmail, String password) {
		DataAccessObject object = new DataAccessObject();
		object.connectionPoolFactory();
		String select = "select * from Students where Email = ?";
		
		String userPassword = "";
		try {
			object.pst = object.con.prepareStatement(select);
			object.pst.setString(1, email);
			object.res = object.pst.executeQuery();
			if (object.res.next()) {
				userPassword = object.res.getString(5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("enterd into send email");
		// create an instance of Properties Class
		Properties properties = new Properties();

		/*
		 * Specifies the IP address of your default mail server for e.g if you are using
		 * gmail server as an email sever you will pass smtp.gmail.com as value of
		 * mail.smtp host. As shown here in the code. Change accordingly, if your email
		 * id is not a gmail id
		 */
		properties.put("mail.smtp.host", "smtp.gmail.com");
		// below mentioned mail.smtp.port is optional
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		/*
		 * Pass Properties object(props) and Authenticator object for authentication to
		 * Session instance
		 */
		// properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(adminEmail, password);
			}
		});
		session.setDebug(true);

		// 2).compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(adminEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Your password is: ");
			message.setText(userPassword);
			// session.setAttribute("otp",otp);

			// 3). Send message
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", 587, adminEmail, password);
			transport.send(message);

			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
