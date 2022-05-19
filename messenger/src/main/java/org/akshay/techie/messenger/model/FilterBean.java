package org.akshay.techie.messenger.model;

import jakarta.ws.rs.QueryParam;

public class FilterBean {
	
	private @QueryParam("year") int year;
	private @QueryParam("day") int  day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	

}
