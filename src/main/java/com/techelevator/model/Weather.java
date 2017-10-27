package com.techelevator.model;

public class Weather {
	
	private int fiveDayForcastValue;
	private int low;
	private int high;
	private String forecast;
	private String weatherMessage;
	

	
	public int getFiveDayForcastValue() {
		return fiveDayForcastValue;
	}
	public void setFiveDayForcastValue(int fiveDayForcastValue) {
		this.fiveDayForcastValue = fiveDayForcastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getWeatherMessage() {
		
		if(forecast.equalsIgnoreCase("snow")){
			if(high < 20 || low < 20){
				weatherMessage = "Pack snowshoes and beware exposure to frigid temperatures.";
			}else if( high - low > 20){
				weatherMessage = "Pack snowshoes and wear breathable layers.";
			}else if( (high - low > 20)&& high > 75){
					weatherMessage = "Pack snowshoes,wear breathable layers and bring an extra gallon of water.";
			}else if(high > 75){
				weatherMessage = "Pack snowshoes and bring an extra gallon of water.";
			} else {
				weatherMessage = "Pack snowshoes";
			}
		} else if (forecast.equalsIgnoreCase("rain")){
			if(high < 20 || low < 20){
				weatherMessage = "Pack rain gear and waterproof shoes. Beware of exposure to frigid temperatures.";
			}else if( high - low > 20){
				weatherMessage = "Pack rain gear and waterproof shoes. Wear breathable layers.";
			}else if( (high - low > 20)&& high > 75){
					weatherMessage = "Pack rain gear,waterproof shoes, wear breathable layers and bring an extra gallon of water.";
			}else if(high > 75){
				weatherMessage = "Pack rain gear,waterproof shoes and bring an extra gallon of water.";
			}else {
				weatherMessage = "Pack rain gear and waterproof shoes.";
			}
		}else if (forecast.equalsIgnoreCase("thunderstorms")){
			if(high < 20 || low < 20){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Beware of exposure to frigid temperatures.";
			}else if( high - low > 20){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathable layers.";
			}else if( (high - low > 20)&& high > 75){
					weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathble layers and bring an extra gallon of water.";
			}else if(high > 75){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Bring an extra gallon of water.";
			}else {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges";
			}	
		}else if (forecast.equalsIgnoreCase("sunny")){
			if(high < 20 || low < 20){
				weatherMessage = "Pack sunblock. Beware of exposure to frigid temperatures.";
			}else if( high - low > 20){
				weatherMessage = "Pack sunblock. Wear breathable layers.";
			}else if( (high - low > 20)&& high > 75){
					weatherMessage = "Pack sunblock, wear breathable layers and bring an extra gallon of water.";
			}else if(high > 75){
				weatherMessage = "Pack sunblock and bring an extra gallon of water.";
			}else {
				weatherMessage = "Pack sunblock";
			}	
		} else {
			if(high < 20 || low < 20){
				weatherMessage = "Beware of exposure to frigid temperatures.";
			}else if( high - low > 20){
				weatherMessage = "Wear breathable layers.";
			}else if( (high - low > 20)&& high > 75){
					weatherMessage = "Wear breathable layers and bring an extra gallon of water.";
			}else if(high > 75){
				weatherMessage = "Bring an extra gallon of water.";
			}
		}
		
		return weatherMessage;
	}
	public void setWeatherMessage(String weatherMessage) {
		this.weatherMessage = weatherMessage;
	}
	public String getParsedForecast() {
		String parsedForecast = forecast.replace(" ", "");
		
		return parsedForecast;
	}

	
	
}
