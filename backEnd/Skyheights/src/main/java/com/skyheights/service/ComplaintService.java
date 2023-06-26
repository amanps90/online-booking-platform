package com.skyheights.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.dto.PostComplaintDTO;
import com.skyheights.model.Booking;
import com.skyheights.model.Complaint;
import com.skyheights.model.User;
import com.skyheights.dao.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	ComplaintRepository complaintRepository;
	
	public void addComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		
	}

	public void deleteComplaintById(int id) {
		complaintRepository.deleteById(id);
		
	}

	public List<Complaint> showAll() {
		return complaintRepository.findAll();
	}
	
	public List<Complaint> isActive(){
		return complaintRepository.findByIsActive(true);
	}

	public void postAdminReply(int id, String reply,boolean status) {
		Date d = new Date(System.currentTimeMillis());
		Complaint complaint = complaintRepository.findById(id).get();
		complaint.setAdminComplaintReply(reply);
		complaint.setActive(false);
		complaint.setComplaintStatus(status);
		complaint.setDateOfComplaintResolved((java.sql.Date) d);
		complaintRepository.save(complaint);
	}

	public List<Complaint> getComplaintsByUserId(User id) {
		
		return complaintRepository.findByUser(id);
	}

}
