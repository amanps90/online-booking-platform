package com.skyheights.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.dto.LoginDTO;
import com.skyheights.dto.OtpDto;
import com.skyheights.dto.UserDTO;
import com.skyheights.model.MessageResponse;
import com.skyheights.model.User;
import com.skyheights.service.EmailService;
import com.skyheights.service.ResponseService;
import com.skyheights.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	EmailService emailService;

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("<h1>Welcome all </h1>", HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<String> user() {
		return new ResponseEntity<>("<h1>Welcome User</h1>", HttpStatus.OK);
	}

	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
		return new ResponseEntity<>("<h1>Welcome Admin</h1>", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginDTO dto) {
		System.out.println("in login");

		User user = userService.authenticate(dto);
		if (user != null) {
			try {
				if (user.isActive()) {
					emailService.generateOneTimePassword(user);
				}
				System.out.println("success login");
				return ResponseService.success(user);
			} catch (UnsupportedEncodingException | MessagingException e) {
				e.printStackTrace();
			}

		}

		return ResponseService.success(null);

	}

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		User user = userService.addUser(newUser);
		if (user != null) {
			try {
				emailService.sendVerificationEmail(user);
				return ResponseService.success(user);
			} catch (UnsupportedEncodingException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ResponseService.success(null);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		userService.update(user, id);
		return new ResponseEntity<String>("User updated successfully", HttpStatus.OK);

	}

	@GetMapping("/showUserProfile/{id}")
	public ResponseEntity<User> showUserById(@PathVariable int id) {
		return new ResponseEntity<User>(userService.showUserById(id), HttpStatus.OK);
	}

	@PostMapping("/sendOtpEmail")
	public ResponseEntity<MessageResponse> testEmail(@RequestBody User user) {
		try {
			emailService.generateOneTimePassword(user);
			return new ResponseEntity<MessageResponse>(new MessageResponse("mail sent"), HttpStatus.OK);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<MessageResponse>(new MessageResponse("error in mail sending"),
					HttpStatus.NOT_FOUND);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<MessageResponse>(new MessageResponse("error in mail sending"),
					HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<MessageResponse> verifyOtp(@RequestBody OtpDto otpDto) {
		if (userService.verifyOtp(otpDto)) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("true"), HttpStatus.OK);
		} else {
			return new ResponseEntity<MessageResponse>(new MessageResponse("false"), HttpStatus.OK);
		}

	}

	@PostMapping("/activateAccount")
	public ResponseEntity<MessageResponse> activateAccount(@RequestBody String code) {
		if (userService.activateIfCorrect(code)) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("success"), HttpStatus.OK);
		} else
			return new ResponseEntity<MessageResponse>(new MessageResponse("failed"), HttpStatus.OK);
	}
	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<MessageResponse> updateUser(@PathVariable int id,@RequestBody UserDTO user){
		userService.update(user,id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Profile updated successfuly"), HttpStatus.CREATED);
		
	}
}
