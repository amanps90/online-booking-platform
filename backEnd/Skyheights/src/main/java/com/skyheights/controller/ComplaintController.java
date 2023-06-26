package com.skyheights.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skyheights.dto.ComplaintDTO;
import com.skyheights.dto.PostComplaintDTO;
import com.skyheights.model.Booking;
import com.skyheights.model.Complaint;
import com.skyheights.model.MessageResponse;
import com.skyheights.model.User;
import com.skyheights.service.ComplaintService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;
	
	@PostMapping("/addComplaint")
	public ResponseEntity<MessageResponse> addComplaint(@RequestBody PostComplaintDTO postCompDTO){
		Date d = new Date(System.currentTimeMillis());
		
		Complaint complaint = new Complaint();
		complaint.setComplaintDescription(postCompDTO.getComplaintDescription());
		complaint.setBooking(postCompDTO.getBooking());
		complaint.setUser(postCompDTO.getUser());
		complaint.setActive(true);
		complaint.setDateOfComplaintRegister((java.sql.Date) d);
		complaintService.addComplaint(complaint);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Complaint added successfuly"), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteComplaint/{id}")
	public ResponseEntity<String> deleteComplaint(@PathVariable int id){
		complaintService.deleteComplaintById(id);
		return new ResponseEntity<String>("Complaint deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/showAllComplaints123")
	public ResponseEntity<List<Complaint>> getAllComplaints(){
		return new ResponseEntity<List<Complaint>>(complaintService.showAll(), HttpStatus.OK);
	}
	
	@GetMapping("/showAllComplaints")
	public ResponseEntity<List<Complaint>> getAllComplaintForAdmin(){
		return new ResponseEntity<List<Complaint>>(complaintService.isActive(), HttpStatus.OK);
	}
	
	@PutMapping("/postAdminReply/{id}")
	public void postAdminReply(@PathVariable int id,@RequestBody ComplaintDTO reply){
		complaintService.postAdminReply(id,reply.getReply(),reply.isStatus());
		
	}
	
	@GetMapping("/showComplaintsByUserId/{id}")
	public ResponseEntity<List<Complaint>> getAllComplaintsByUserId(@PathVariable User id){
		
		return new ResponseEntity<List<Complaint>>(complaintService.getComplaintsByUserId(id), HttpStatus.OK);
	}

	
}
