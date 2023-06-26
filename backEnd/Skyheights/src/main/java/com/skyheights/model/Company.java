package com.skyheights.model;

import javax.persistence.*;

@Entity
@Table(name = "company_table")
public class Company {
	@Id
	private int companyId;
	private String companyName;
	
	//default constructor
	public Company() {
		
	}
	
	//setter getters 
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
