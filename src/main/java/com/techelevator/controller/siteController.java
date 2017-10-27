package com.techelevator.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.WeatherDAO;
import com.techelevator.model.Conversion;
import com.techelevator.model.Park;
import com.techelevator.model.Weather;

@Controller

public class siteController {
	
	@Autowired
	ParkDAO parkDao;
	@Autowired
	WeatherDAO weatherDao;
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String showHomePage(ModelMap modelHolder, @ModelAttribute Park newNationalPark){
		List<Park> newParkList = parkDao.getAllParks();
		modelHolder.put("parks", newParkList);
		
		return "index";
		
	}
	@RequestMapping(path="/parkDetail/{parkCode}",method=RequestMethod.GET)
	public String showParkDetail(@PathVariable String parkCode, HttpSession session, ModelMap modelHolder){
		String convert = (String) session.getAttribute("convert");
		if (convert == null) {
			convert ="F";
			session.setAttribute("convert", convert);
		}
		
		List<Weather> newWeatherList = weatherDao.getWeatherByParkcode(parkCode);
		Park newPark = parkDao.getParkByParkCode(parkCode);		
		
		if (convert.equals("C")) {
			for (Weather tempWeather : newWeatherList) {
				int tempVar;
				tempVar = (int) Conversion.convertFtoC(tempWeather.getHigh());
				tempWeather.setHigh(tempVar);
				tempVar = (int) Conversion.convertFtoC(tempWeather.getLow());
				tempWeather.setLow(tempVar);
			}
				BigDecimal tempBigD = Conversion.sqMilesToSqKilometers(newPark.getAcreage());
				newPark.setAcreage(tempBigD.setScale(0, RoundingMode.HALF_UP));
				tempBigD = Conversion.ftToMeters(newPark.getElevationInFeet());
				newPark.setElevationInFeet(tempBigD.setScale(0, RoundingMode.HALF_UP));
				tempBigD =  Conversion.milesToKm(newPark.getMilesOfTrail());
				newPark.setMilesOfTrail(tempBigD.setScale(0, RoundingMode.HALF_UP));

			
		}
		
		
		modelHolder.put("park", newPark);
		modelHolder.put("parkWeather", newWeatherList);
		

		return "parkDetail";
	}
	@RequestMapping(path="/parkDetail/{parkCode}",method=RequestMethod.POST)
	public String showParkDetailWithConversion(@PathVariable String parkCode, @RequestParam String convert, HttpSession session, ModelMap modelHolder){
		session.setAttribute("convert", convert);
		
		return "redirect:/parkDetail/" + parkCode;
	}
}
