package com.covid19.model;

public class LocationStats {

	
	private String state;
	private String country;
	private int confirmedCases;
	private int deaths;
	private int recovered;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(int confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", lastUpdated=" + ", confirmedCases=" + confirmedCases + ", deaths=" + deaths + ", recovered=" + recovered + "]";
	}
	
	
	
}
