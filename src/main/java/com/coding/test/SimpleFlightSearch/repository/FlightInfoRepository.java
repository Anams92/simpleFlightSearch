package com.coding.test.SimpleFlightSearch.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.coding.test.SimpleFlightSearch.dao.FlightInformationDAO;
import com.google.gson.Gson;

@Repository
public class FlightInfoRepository {
	
	private List<FlightInformationDAO> flightInfo;
	
	public List<FlightInformationDAO> getFlightInfo() {
		return flightInfo;
	}

	@PostConstruct
	public void Init() {
		loadFlightInfo();
	}
	
	private void loadFlightInfo() {
		try {
//			ClassPathResource classPathResource = new ClassPathResource("FlightSample.json");
//			InputStream ioStream = classPathResource.getInputStream();
//			dataAsString = IOUtils.toString(ioStream);
			List<Map> listMap = null;
			String dataAsString = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("FlightSample.json"));
			if (dataAsString != null) {
				listMap = new Gson().fromJson(dataAsString, List.class);
			}
			if (listMap != null && listMap.size() > 0) {
				flightInfo = listMap.stream().map(e -> getFlightInfo(e)).collect(Collectors.toList());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private FlightInformationDAO getFlightInfo(Map e) {
		return FlightInformationDAO.instance()
			.aircraft(e.get("aircraft").toString())
	        .departure(e.get("departure").toString())
	        .arrival(e.get("arrival").toString())
	        .carrier(e.get("carrier").toString())
	        .destination(e.get("destination").toString())
	        .origin(e.get("origin").toString())
	        .flightNumber(e.get("flightNumber").toString())
	        .status(e.get("status").toString())
	        .distance(((Double)e.get("distance")).longValue())
	        .travelTime(e.get("travelTime").toString());
	}
	
	public List<FlightInformationDAO> findFlights(Date date, String origin, String destination, String flightNumber){
		if (flightInfo == null || flightInfo.size() == 0) {
			return new ArrayList<FlightInformationDAO>();
		}
		
		Stream<FlightInformationDAO> retFlight = flightInfo.stream();
		
		if (date != null) {
			retFlight = retFlight.filter(f -> f.getDeparture().compareTo(date) < 0);
		}
		
		if (StringUtils.isNotEmpty(origin)) {
			retFlight = retFlight.filter(f -> f.getOrigin().equalsIgnoreCase(origin));
		}
		
		if (StringUtils.isNotEmpty(flightNumber)) {
			retFlight = retFlight.filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
		}
		
		if (StringUtils.isNotEmpty(destination)) {
			retFlight = retFlight.filter(f -> f.getDestination().equalsIgnoreCase(destination));
		}
		
		
		return retFlight.collect(Collectors.toList());
		
	}
	
}
