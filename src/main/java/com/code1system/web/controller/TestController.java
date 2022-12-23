package com.code1system.web.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.sms.SmsInfo;

@RestController
public class TestController {
	@RequestMapping("/mail")	
	public String mailTest() {
		Properties props = System.getProperties();
		//props.setProperty("mail.smtp.host", "127.0.0.1");
		props.setProperty("mail.smtp.host", "smtp.daum.net");
		props.setProperty("mail.smtp.port", "465"); 
		props.setProperty("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.ssl.enable", "true");
		try {
			//Session session = Session.getDefaultInstance(props);
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("b-h.jeon", "los65535");
	            }
	        });
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("b-h.jeon@daum.net"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("b-h.jeon@daum.net"));
			message.setSubject("mail test subject");
			message.setText("qwwer");
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "EMT";
	}
	
	@RequestMapping("/smstest")	
	public String smsTest() {
		SmsInfo info = new SmsInfo();
		info.setRecvphone("01031942777");
		info.setCallback("01031942888");
		info.setKey("221220050402330");
		info.setEmpno("12345678");
		info.setMessage("으아아아아아");
		byte[] a = info.toByteArray();
		return info.toString() + a.length;
	}
}
