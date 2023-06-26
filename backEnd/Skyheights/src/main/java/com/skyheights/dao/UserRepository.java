package com.skyheights.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyheights.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//User findByUserEmail(String email);
	Optional<User> findByUserEmail(String email);
	Optional<User> findByUserName(String userName);
	List<User> findByIsBlocked(boolean isBlocked);
	User findByVerificationCode(String code);
}
