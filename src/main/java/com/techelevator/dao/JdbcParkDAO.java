package com.techelevator.dao;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;

@Component
public class JdbcParkDAO implements ParkDAO {

	
private JdbcTemplate jdbcTemplate;
	


	@Autowired
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()){
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park newPark = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
		if(results.next()){
			newPark = mapRowToPark(results);
		}
		return newPark;
	}
	

	
	private Park mapRowToPark(SqlRowSet row){
		Park newPark = new Park();
		newPark.setParkCode(row.getString("parkcode"));
		newPark.setParkName(row.getString("parkname"));
		newPark.setState(row.getString("state"));
		newPark.setAcreage(row.getBigDecimal("acreage").setScale(2, RoundingMode.HALF_UP)); 
		newPark.setElevationInFeet(row.getBigDecimal("elevationinfeet").setScale(2, RoundingMode.HALF_UP));
		newPark.setMilesOfTrail(row.getBigDecimal("milesoftrail").setScale(2, RoundingMode.HALF_UP));
		newPark.setNumberOfCampsites(row.getInt("numberofcampsites"));
		newPark.setClimate(row.getString("climate"));
		newPark.setYearFounded(row.getString("yearfounded"));
		newPark.setAnnualVisitorCount(row.getLong("annualvisitorcount"));
		newPark.setInspirationalQuote(row.getString("inspirationalquote"));
		newPark.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
		newPark.setParkDescription(row.getString("parkdescription"));
		newPark.setEntryFee(row.getBigDecimal("entryfee").setScale(2, RoundingMode.HALF_UP));
		newPark.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		
		return newPark;
	}


}
