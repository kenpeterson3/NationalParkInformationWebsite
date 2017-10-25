package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.WeatherDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Weather;

@Controller
public class siteController {
	
	@Autowired
	ParkDAO parkDao;
	WeatherDAO weatherDao;
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String showHomePage(ModelMap modelHolder, @ModelAttribute Park newNationalPark){
		List<Park> newParkList = parkDao.getAllParks();
		modelHolder.put("parks", newParkList);
		
		return "index";
		
	}
	@RequestMapping(path="/parkDetail/{parkCode}",method=RequestMethod.GET)
	public String showParkDetail(@PathVariable String parkCode, HttpSession session){
		Park newPark = parkDao.getParkByParkCode(parkCode);
		session.setAttribute("park", newPark);
		
		return "parkDetail";
	}
	@RequestMapping(path="/parkDetail/{parkCode,unitOfMeasure}",method=RequestMethod.POST)
	public String showParkDetailWithConversion(@PathVariable String parkCode,@PathVariable String unitOfMeasure, HttpSession session){
		//Park newPark = parkDao.getParkByParkCode(parkCode);
		//session.setAttribute("park", newPark);
		List<Weather> newWeatherList = weatherDao.getWeatherByParkcode(parkCode);
		session.setAttribute("parkWeather", newWeatherList);
		return "parkDetail";
	}
}
