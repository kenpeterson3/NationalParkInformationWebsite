package com.techelevator.model;

import java.math.BigDecimal;

public class Conversion {

	private BigDecimal distance;
	private BigDecimal area;
	private double temperature;
	
	
	public double convertFtoC(int f){
		temperature = ((f-32)*0.556);
		return temperature;
	}
	public double convertCtoF(int c){
		temperature = ((c*1.8)+32);
		return temperature;
	}
	public BigDecimal milesToKm(BigDecimal m){
		distance = m.multiply(new BigDecimal(1.609));
		return distance;
	}
	public BigDecimal kmToMiles(BigDecimal km){
		distance = km.multiply(new BigDecimal(0.6214));
		return distance;
	}
	public BigDecimal sqMilesToSqKilometers(BigDecimal sqm){
		area = sqm.multiply(new BigDecimal(2.59));
		return area;
	}
	public BigDecimal sqKilometersToSqMiles(BigDecimal sqkm){
		area = sqkm.multiply(new BigDecimal(0.6214));
		return area;
	}
	public BigDecimal ftToMeters(BigDecimal ft){
		distance = ft.multiply(new BigDecimal(0.3048));
		return distance;
	}
	public BigDecimal metersToFt(BigDecimal mt){
		distance = mt.multiply(new BigDecimal(3.281));
		return distance;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	
}
