package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.model.Weather;

@Component
public class JdbcWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkcode(String parkCode) {
		List<Weather> parkWeather = new ArrayList<>();
		String sqlSelectParkWeather = "SELECT * FROM weather WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkWeather, parkCode);
		while(results.next()){
			parkWeather.add(mapRowToWeather(results));
		}
		
		return parkWeather;
	}
		private Weather mapRowToWeather(SqlRowSet row){
			Weather newWeather = new Weather();
			newWeather.setFiveDayForcastValue(row.getInt("fivedayforecastvalue"));
			newWeather.setForecast(row.getString("forecast"));
			newWeather.setHigh(row.getInt("high"));
			newWeather.setLow(row.getInt("low"));
			return newWeather;
		}
}
