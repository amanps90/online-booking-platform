package com.skyheights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.dao.CompanyRepository;
import com.skyheights.dao.OfferRepository;
import com.skyheights.dto.OfferDTO;
import com.skyheights.model.Company;
import com.skyheights.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	OfferRepository offerDao;
	@Autowired
	CompanyRepository companyDao;

	public List<Offer> getAllOffers() {
	
		return offerDao.findAll();
	}

	public void addOffer(OfferDTO offerDto) {
		Company currentCompany = companyDao.findByCompanyName(offerDto.getCompany());
		Offer offer =new Offer();
		offer.setCompany(currentCompany);
		offer.setDiscount(offerDto.getDiscount());
		offerDao.save(offer);
	}

	public void updateOffer(int id, OfferDTO offerDto) {
		Company currentCompany = companyDao.findByCompanyName(offerDto.getCompany());
		Offer offer =offerDao.findById(id).get();
		offer.setCompany(currentCompany);
		offer.setDiscount(offerDto.getDiscount());
		offerDao.save(offer);
		
	}

	public void deleteOffer(int id) {
		offerDao.deleteById(id);
	}

}
