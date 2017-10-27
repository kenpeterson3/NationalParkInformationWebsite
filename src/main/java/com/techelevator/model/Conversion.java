package com.techelevator.model;

import java.math.BigDecimal;

public class Conversion {

	private static BigDecimal distance;
	private static BigDecimal area;
	private static double temperature;
	
	
	public static double convertFtoC(double f){
		temperature = ((f-32)*0.556);
		return temperature;
	}
	public static double convertCtoF(double c){
		temperature = ((c*1.8)+32);
		return temperature;
	}
	public static BigDecimal milesToKm(BigDecimal m){
		distance = m.multiply(new BigDecimal(1.609));
		return distance;
	}
	public static BigDecimal kmToMiles(BigDecimal km){
		distance = km.multiply(new BigDecimal(0.6214));
		return distance;
	}
	public static BigDecimal sqMilesToSqKilometers(BigDecimal sqm){
		area = sqm.multiply(new BigDecimal(2.59));
		return area;
	}
	public static BigDecimal sqKilometersToSqMiles(BigDecimal sqkm){
		area = sqkm.multiply(new BigDecimal(0.6214));
		return area;
	}
	public static BigDecimal ftToMeters(BigDecimal ft){
		distance = ft.multiply(new BigDecimal(0.3048));
		return distance;
	}
	public static BigDecimal metersToFt(BigDecimal mt){
		distance = mt.multiply(new BigDecimal(3.281));
		return distance;
	}
	public static BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		Conversion.distance = distance;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		Conversion.temperature = temperature;
	}
	public static BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		Conversion.area = area;
	}
	
}
