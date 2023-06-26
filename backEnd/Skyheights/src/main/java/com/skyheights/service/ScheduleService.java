package com.skyheights.service;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyheights.dao.CityRepository;
//import com.skyheights.dao.CityRepository;
import com.skyheights.dao.ScheduleRepository;

import com.skyheights.dto.ScheduleDTO;
import com.skyheights.dto.SearchDto;
//import com.skyheights.dto.SearchDto;
import com.skyheights.model.City;
import com.skyheights.model.Flight;
import com.skyheights.model.Schedule;

@Service
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleDao;
	@Autowired
	CityRepository cityDao;

	public void addSchedule(ScheduleDTO scheduleDto) {
		Time depatureTime = Time.valueOf(scheduleDto.getDepatureTime());
		Time arrivalTime = Time.valueOf(scheduleDto.getArrivalTime());

		City fromCity = cityDao.findByCityName(scheduleDto.getFromCity());
		City toCity = cityDao.findByCityName(scheduleDto.getToCity());
		Schedule newSchedule = new Schedule();
		newSchedule.setFromCity(fromCity);
		newSchedule.setToCity(toCity);
		newSchedule.setDepatureDate(scheduleDto.getDepatureDate());
		newSchedule.setArrivalDate(scheduleDto.getArrivalDate());
		newSchedule.setDepatureTime(depatureTime);
		newSchedule.setArrivalTime(arrivalTime);
		newSchedule.setFlight(scheduleDto.getFlight());

		scheduleDao.save(newSchedule);
	}

	public void deleteScheudle(int scheduleId) {
		scheduleDao.deleteById(scheduleId);
	}

	public List<Schedule> getAllSchedule() {
		return scheduleDao.findAll();
	}
	public List<Schedule>getScheduleByFlight(Flight flight){
		return scheduleDao.findByFlight(flight);
	}
	public void updateSchedule(int scheduleId, ScheduleDTO updatedSchedule) {
		System.out.println(updatedSchedule);
		Time depatureTime = Time.valueOf(updatedSchedule.getDepatureTime());
		Time arrivalTime = Time.valueOf(updatedSchedule.getArrivalTime());

		City fromCity = cityDao.findByCityName(updatedSchedule.getFromCity());
		City toCity = cityDao.findByCityName(updatedSchedule.getToCity());
		Schedule schedule = scheduleDao.findById(scheduleId).get();
		schedule.setFromCity(fromCity);
		schedule.setToCity(toCity);
		schedule.setDepatureTime(depatureTime);
		schedule.setDepatureDate(updatedSchedule.getDepatureDate());
		schedule.setArrivalDate(updatedSchedule.getArrivalDate());
		schedule.setArrivalTime(arrivalTime);
		schedule.setDepatureTime(depatureTime);
		scheduleDao.save(schedule);
	}
	
public List<City> getAllCity() {
		
		return cityDao.findAll();
	}

	
	  public List<Schedule> getSearchResult(SearchDto searchDto) { City fromCity =
	  cityDao.findByCityName(searchDto.getFromCity()); City toCity =
	  cityDao.findByCityName(searchDto.getToCity()); return
	  scheduleDao.findByFromCityAndToCityAndDepatureDate(fromCity,toCity,searchDto.
	  getDoj()); }
	 
}
