package com.coding.test.SimpleFlightSearch.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.test.SimpleFlightSearch.dao.FlightInformationDAO;
import com.coding.test.SimpleFlightSearch.model.FlightInformation;
import com.coding.test.SimpleFlightSearch.repository.FlightInfoRepository;

@Service
public class FlightSearchService {

	@Autowired
	private FlightInfoRepository flightInfoRepo;
	
	@Autowired
	private ModelMapper objectMapper;
	
	public List<FlightInformation> findFlights(Date date, String origin, String destination, String flightNumber) {
		List<FlightInformationDAO> flightDaoList =  flightInfoRepo.findFlights(date, origin, destination, flightNumber);
		return flightDaoList
			        .stream()
			        .map(source -> objectMapper.map(source, FlightInformation.class))
			        .collect(Collectors.toList());		
	}
}
