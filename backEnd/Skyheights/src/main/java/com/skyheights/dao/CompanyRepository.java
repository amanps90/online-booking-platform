package com.skyheights.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyheights.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Company findByCompanyName(String companyName);
}
