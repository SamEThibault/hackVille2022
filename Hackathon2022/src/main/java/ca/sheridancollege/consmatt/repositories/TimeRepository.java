package ca.sheridancollege.consmatt.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.consmatt.beans.Time;

@Repository
public class TimeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public void addTime(Time time) { //Method used to insert data from the addTask HTML form into the tasks SQL database
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO times (monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES (:monday, :tuesday, :wednesday, :thursday, :friday, :saturday, :sunday)"; 
		parameters.addValue("monday", time.getMonday());
		parameters.addValue("tuesday", time.getTuesday());
		parameters.addValue("wednesday", time.getWednesday());
		parameters.addValue("thursday", time.getThursday());
		parameters.addValue("friday", time.getFriday());
		parameters.addValue("saturday", time.getSaturday());
		parameters.addValue("sunday", time.getSunday());
		jdbc.update(query, parameters);
	} //Method ends
	
}
