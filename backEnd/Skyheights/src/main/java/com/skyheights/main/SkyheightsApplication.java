package com.skyheights.main;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication(scanBasePackages = "com.skyheights")
@EnableJpaRepositories(basePackages = "com.skyheights.dao")
@EntityScan(basePackages = "com.skyheights.model")
public class SkyheightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyheightsApplication.class, args);
	}
	
	//so spring will create this dependency for me 
	//I provide configurate for smtp here 
	 @Bean  
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("webmail.evolvingsols.com");
	        mailSender.setPort(587);
	          
	        mailSender.setUsername("Trng1");
	        mailSender.setPassword("Cyb@ge@531");
	          
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable.required", "true");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.ssl.enable.trust", "*");
	        return mailSender;
	    }
}
