package com.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.p1.dto.EmailDto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(EmailDto email) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(email.getTo());
		msg.setSubject(email.getSubject());
		msg.setText(email.getBody());
		javaMailSender.send(msg);
	}
}
