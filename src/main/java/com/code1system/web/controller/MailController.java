package com.code1system.web.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code1system.web.dto.MailDto;

import io.netty.handler.codec.http.HttpRequest;

@RestController
public class MailController {
	
	@Value("${code1system.mailfrom}")
	private String mailFrom;
	
	@RequestMapping("/sendmail")
	public ResponseEntity<Object> sendMail(MailDto mailDto, HttpSession session){
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "127.0.0.1");
		//props.setProperty("mail.smtp.host", "smtp.daum.net");
		//props.setProperty("mail.smtp.port", "465"); 
		//props.setProperty("mail.smtp.auth", "true"); 
		//props.setProperty("mail.smtp.ssl.enable", "true");
		try {
			Session mailSession = Session.getDefaultInstance(props);
//	        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	                return new PasswordAuthentication("b-h.jeon", "los65535");
//	            }
//	        });
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDto.getAddress()));
			message.setSubject(mailDto.getTitle());
			message.setText(mailDto.getText());
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>("EMT", HttpStatus.OK);
	}
}
