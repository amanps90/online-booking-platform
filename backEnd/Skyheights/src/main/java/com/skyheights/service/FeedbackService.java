package com.skyheights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.model.Feedback;
import com.skyheights.dao.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
    FeedbackRepository feedbackRepository;

	public Feedback addFeedback(Feedback newFeedback) {
		return feedbackRepository.save(newFeedback);
		
	}

	public List<Feedback> showAllFeedback() {
		return feedbackRepository.findAll();
	}
}
