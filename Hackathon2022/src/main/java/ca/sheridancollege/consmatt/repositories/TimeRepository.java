package ca.sheridancollege.consmatt.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.consmatt.beans.Task;
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


	public ArrayList<Time> getTime() { //Method used to display information from tasks SQL database based on their respective days
		ArrayList<Time> times = new ArrayList<Time>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM times"; //This chooses the rows with the specific day
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row: rows) {
			Time d = new Time();
			d.setMonday((Integer)row.get("monday"));
			d.setTuesday((Integer)row.get("tuesday"));
			d.setWednesday((Integer)row.get("wednesday"));
			d.setThursday((Integer)row.get("thursday"));
			d.setFriday((Integer)row.get("friday"));
			d.setSaturday((Integer)row.get("saturday"));
			d.setSunday((Integer)row.get("sunday"));
			times.add(d);
		}
		return times;
	} //Method ends

}