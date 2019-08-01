package com.eric.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public class EmployeeMailSenderRepo {

	@Autowired
	private JavaMailSender sender;
	
	public String sendingMail(String setTo, String setSubject, String setText) {
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			helper.setTo(setTo);
			helper.setSubject(setSubject);
			helper.setText(setText);
		}catch(MessagingException e) {
			e.printStackTrace();
			return "Exception while sending mail..";
		}
		sender.send(msg);
		return "Mail set succesfully!";
	}
}
