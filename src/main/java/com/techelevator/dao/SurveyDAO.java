package com.techelevator.dao;

import java.util.Map;

import com.techelevator.model.Survey;

public interface SurveyDAO {
	public void saveSurvey(Survey newSurvey);
	public Map<String, Integer> getFavoritePark();
}
