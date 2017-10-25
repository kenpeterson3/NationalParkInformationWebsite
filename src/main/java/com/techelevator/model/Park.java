package com.techelevator.model;

import java.math.BigDecimal;

public class Park {
	
	private String parkCode;
	private String parkName;
	private String state;
	private long acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private String yearFounded;
	private long annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private String parkDescription;
	private BigDecimal entryFee;
	private int numberOfAnimalSpecies;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getAcreage() {
		return acreage;
	}
	public void setAcreage(long acreage) {
		this.acreage = acreage;
	}
	public int getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(String yearFounded) {
		this.yearFounded = yearFounded;
	}
	public long getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(long annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	public BigDecimal getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}

}
