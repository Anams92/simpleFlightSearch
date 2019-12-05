package com.coding.test.SimpleFlightSearch.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FlightInformationDAO {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
	private String flightNumber;
	private String carrier;
	private String origin;
	private Date departure;
	private String destination;
	private Date arrival;
	private String aircraft;
	private Long distance;
	private String travelTime;
	private String status;
	
	public static FlightInformationDAO instance() {
		return new FlightInformationDAO();
	}
	
	public FlightInformationDAO flightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
		return this;
	}
	
	public FlightInformationDAO carrier(String carrier) {
		this.carrier = carrier;
		return this;
	}
	
	public FlightInformationDAO origin(String origin) {
		this.origin = origin;
		return this;
	}
	
	public FlightInformationDAO departure(String departure) {
		try {
			this.departure = sdf.parse(departure);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public FlightInformationDAO destination(String destination) {
		this.destination = destination;
		return this;
	}
	
	public FlightInformationDAO arrival(String arrival) {
		try {
			this.arrival = sdf.parse(arrival);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public FlightInformationDAO aircraft(String aircraft) {
		this.aircraft = aircraft;
		return this;
	}
	
	public FlightInformationDAO distance(long distance) {
		this.distance = distance;
		return this;
	}
	
	public FlightInformationDAO travelTime(String travelTime) {
		this.travelTime = travelTime;
		return this;
	}
	
	public FlightInformationDAO status(String status) {
		this.status = status;
		return this;
	}
	
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
