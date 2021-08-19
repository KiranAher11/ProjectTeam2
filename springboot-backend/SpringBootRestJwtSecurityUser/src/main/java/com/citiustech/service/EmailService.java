package com.citiustech.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.citiustech.model.EmailDto;



@Service
public class EmailService {

	@Autowired
	private TemplateEngine engine;

	@Autowired
	private JavaMailSender javaMailSender;



	public String sendMail(EmailDto emailDto) throws MessagingException {
		System.out.println(emailDto);
		String[] emailIds = new String[2];
		emailIds[0] = emailDto.getPatientEmail();
		emailIds[1] = emailDto.getPhysicianEmail();

		Context context = new Context();
		context.setVariable("email", emailDto);

		String process = engine.process("appointment", context);

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

		messageHelper.setSubject(emailDto.getStatus());

		messageHelper.setText(process, true);

		messageHelper.setTo(emailIds);

		javaMailSender.send(mimeMessage);
		return "Sent";

	}
	
}
