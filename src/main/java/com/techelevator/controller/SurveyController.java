package com.techelevator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.SurveyDAO;
import com.techelevator.model.Survey;

@Controller
public class SurveyController {

	
	@Autowired
	SurveyDAO surveyDao;
	
	@Autowired
	ParkDAO parkDao;
	
	@RequestMapping(path="/survey",method=RequestMethod.GET)
	public String showSurvey(ModelMap modelHolder) {
		if (! modelHolder.containsAttribute("survey")) {
			modelHolder.put("survey", new Survey());
		}

	return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String processSurvey(@Valid @ModelAttribute Survey newSurvey, BindingResult result, RedirectAttributes flash) {
		flash.addFlashAttribute("survey", newSurvey);
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		surveyDao.saveSurvey(newSurvey);
		
		return "redirect:/confirmation";
	}
	
	@RequestMapping(path="/confirmation",method=RequestMethod.GET)
	public String showConfirmation(@RequestParam String parkCode, @RequestParam Integer parkCount, ModelMap modelHolder) {
		//finish getting top parks.
		
		
		return "confirmation";
	}
}
