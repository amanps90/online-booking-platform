package com.skyheights.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.model.User;
import com.skyheights.dao.UserRepository;
import com.skyheights.dto.LoginDTO;
import com.skyheights.dto.OtpDto;
import com.skyheights.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailService emailService;
	
	public User authenticate(LoginDTO dto) {
		User user = userRepository.findByUserEmail(dto.getUserEmail()).get();
		if(user != null && dto.getUserPassword().equals(user.getUserPassword()))
			return user;
		return null;
	}

	public User addUser(User newUser) {
		//by default a user account is not active  
		newUser.setActive(false);
		//account is not admin
		newUser.setAdmin(false);
		//account is not blocked
		newUser.setBlocked(false);
		//role is user
		newUser.setRoles("ROLE_USER");
		//acount creation date is today
		newUser.setAccountCreationDate(Date.valueOf(LocalDate.now()));
		return userRepository.save(newUser);
	}


	public void update(User user, int id) {
		userRepository.save(user);
	}


	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	public User showUserById(int id) {
		return userRepository.findById(id).get();
	}

	public boolean verifyOtp(OtpDto otpDto) {
		User user = userRepository.findByUserEmail(otpDto.getUserEmail()).get();
		System.out.println(user.getOneTimePassword());
		if(user.isOTPExpired()) {
			System.out.println("inside expire");
			return false;
		}
		else if(user.getOneTimePassword().equals(otpDto.getOtp())) {
			System.out.println("inside equals method");
			emailService.clearOTP(user);
			return true;
		}else
		return false;
	}

	public void blockUserAccount(User user) {
		User currentUser = userRepository.findById(user.getUserId()).get();
		currentUser.setBlocked(true);
		userRepository.save(currentUser);
		
	}
	
	public void unblockUserAccount(User user) {
		User currentUser = userRepository.findById(user.getUserId()).get();
		currentUser.setBlocked(false);
		userRepository.save(currentUser);
		
	}

	public List<User> getAllBlockUsers() {
		// TODO Auto-generated method stub
		return userRepository.findByIsBlocked(true);
	}

	public boolean activateIfCorrect(String code) {
		User user = userRepository.findByVerificationCode(code);
		if(user!=null) {
			user.setActive(true);
			user.setVerificationCode(null);
			userRepository.save(user);
			return true;
		}else
		return false;
	}

public void update(UserDTO user, int id) {
		
		User user1 = userRepository.findById(id).get();
		user1.setUserName(user.getUserName());
		user1.setUserEmail(user.getUserEmail());
		user1.setUserContact(user.getUserContact());
		user1.setUserPassword(user.getUserPassword());
		user1.setGender(user.getGender());
		userRepository.save(user1);
	}


	
}
