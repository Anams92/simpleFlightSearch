package com.flights.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.coding.test.SimpleFlightSearch.dao.FlightInformationDAO;
import com.coding.test.SimpleFlightSearch.repository.FlightInfoRepository;

public class SimpleTest {

	public static void main(String[] args) {
		FlightInfoRepository repo = new FlightInfoRepository();
		repo.Init();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-01");
			
			List<FlightInformationDAO>  flights = repo.findFlights(date, "IAH", "ORD", "");
			
			List<FlightInformationDAO>  flightsAvail = repo.getFlightInfo();
			System.out.println("Flights Available: "+flightsAvail.size());
			for (FlightInformationDAO f : flights) {
//				if (f.getDeparture().compareTo(date) < 0) {
//					System.out.println("depat is before date "+ f.getDeparture());
//				} else if(f.getDeparture().compareTo(date) > 0) {
//					System.out.println("depat is after date" + f.getDeparture());
//				}
				System.out.println(f.getFlightNumber());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
