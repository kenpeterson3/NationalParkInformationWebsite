package com.techelevator.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Survey;

@Component
public class JdbcSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveSurvey(Survey newSurvey) {
		String sqlSaveSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlSaveSurvey, newSurvey.getParkCode(), newSurvey.getEmail(), newSurvey.getState(), newSurvey.getActivityLevel());

	}

	@Override
	public Map<String, Integer> getFavoritePark() {
		Map<String, Integer> favoriteParks = new HashMap<>();
		String sqlSelectTopFiveParks = "SELECT parkcode, COUNT(parkcode) AS countpark FROM survey_result GROUP BY parkcode ORDER BY countpark DESC LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTopFiveParks);
		if (results.next()){
			favoriteParks.put(results.getString("parkcode"), results.getInt("countpark"));
			
		}
		return favoriteParks;
	}
	
	
}
