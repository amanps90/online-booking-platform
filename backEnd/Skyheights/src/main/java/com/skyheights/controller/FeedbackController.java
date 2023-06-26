package com.skyheights.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.dto.FeedbackDTO;
import com.skyheights.model.Feedback;
import com.skyheights.model.MessageResponse;
import com.skyheights.service.FeedbackService;
import com.skyheights.service.ResponseService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

//	@PostMapping("/addFeedback")
//	public ResponseEntity<?> addFeedback(@RequestBody Feedback newFeedback) {
//		Feedback feedback = feedbackService.addFeedback(newFeedback);
//		if (feedback != null)
//			return ResponseService.success(FeedbackDTO.fromEntity(feedback));
//		return ResponseService.success(null);
//	}
	
	@PostMapping("/addFeedback")
	public ResponseEntity<MessageResponse> addFeedback(@RequestBody FeedbackDTO feedbackDTO){
		Feedback feedback = new Feedback();
		feedback.setTiming(feedbackDTO.getTiming());
		feedback.setHospitality(feedbackDTO.getHospitality());
		feedback.setSanitization(feedbackDTO.getSanitization());
		feedback.setFood(feedbackDTO.getFood());
		feedback.setUser(feedbackDTO.getUser());
		feedback.setCompany(feedbackDTO.getCompany());
		feedback.setBooking(feedbackDTO.getBooking());
		feedbackService.addFeedback(feedback);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Feedback added successfuly"), HttpStatus.CREATED);
	}


	@GetMapping("/showAllFeedback")
	public ResponseEntity<?> getAllFeedback() {
		List<Feedback> feedbacklist = feedbackService.showAllFeedback();
		if (feedbacklist.size() != 0) {
			List<FeedbackDTO> dto = new ArrayList<>();
			for (Feedback feedback : feedbacklist)
				dto.add(FeedbackDTO.fromEntity(feedback));
			return ResponseService.success(dto);
		}
		return ResponseService.success(null);
	}
}
