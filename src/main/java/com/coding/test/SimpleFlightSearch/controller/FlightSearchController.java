package com.coding.test.SimpleFlightSearch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.test.SimpleFlightSearch.service.FlightSearchService;
import com.coding.test.SimpleFlightSearch.model.FlightInformation;

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class FlightSearchController {

	@Autowired
	private FlightSearchService flightSearchService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<FlightInformation> search(@RequestParam("date") String date,
			@RequestParam(required = false, value = "origin") String origin,
			@RequestParam(required = false, value = "destination") String destination,
			@RequestParam(required = false, value = "flightNumber") String flightNumber) throws ParseException {

		Date flightDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		validateInputParams(flightDate, origin, destination, flightNumber);
		return flightSearchService.findFlights(flightDate, origin, destination, flightNumber);
	}

	private void validateInputParams(Date date, String origin, String destination, String flightNumber) {
		boolean isValid = true;
		if (date == null) {
			isValid = false;
		}
		if (StringUtils.isNotEmpty(flightNumber)) {
			if (StringUtils.isEmpty(origin) || StringUtils.isEmpty(destination)) {
				isValid = false;
		}
		} else if (StringUtils.isEmpty(destination) || StringUtils.isEmpty(origin)) {
			isValid = false;
		}
		if (!isValid) {
			throw new RuntimeException("Invalid input");
		}
	}
}
