package com.skyheights.service;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.skyheights.dao.UserRepository;
import com.skyheights.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UserRepository userRepo;

	public void generateOneTimePassword(User user) throws UnsupportedEncodingException, MessagingException {
		String OTP = RandomString.make(8);
		user.setOneTimePassword(OTP);
		String time = String.valueOf(System.currentTimeMillis());
		user.setOtpRequestedTime(time);

		userRepo.save(user);

		sendOTPEmail(user, OTP);
	}

	public void sendOTPEmail(User user, String OTP) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("Trng1@evolvingsols.com", "Skyheights");
		helper.setTo(user.getUserEmail());

		String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";

		String content = "<p>Hello " + user.getUserName() + "</p>"
				+ "<p>For security reason, you're required to use the following " + "One Time Password to login:</p>"
				+ "<p><b>" + OTP + "</b></p>" + "<br>" + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		javaMailSender.send(message);
	}

	public void sendVerificationEmail(User user) throws UnsupportedEncodingException, MessagingException {
		String code = RandomString.make(8);
		user.setVerificationCode(code);
		userRepo.save(user);
		String toAddress = user.getUserEmail();
		String content = "Dear [[name]],<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" ;

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		String subject = "Verify your account";
		helper.setFrom("Trng1@evolvingsols.com", "Skyheights");
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", user.getUserName());
		String verifyURL= "http://localhost:4200"
				+ "/verify?code="+code;

		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);

		javaMailSender.send(message);

	}

	public void clearOTP(User customer) {
		customer.setOneTimePassword(null);
//	    customer.setOtpRequestedTime(null);
		userRepo.save(customer);
	}

}
