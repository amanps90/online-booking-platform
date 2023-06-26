package com.skyheights.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyheights.model.Complaint;
import com.skyheights.model.User;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{
	List<Complaint> findByIsActive(boolean isActive);

	List<Complaint> findByUser(User id);
}
