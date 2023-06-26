package com.skyheights.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyheights.model.Company;
import com.skyheights.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

	List<Offer> findByCompany(Company company);

}
