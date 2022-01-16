package ca.sheridancollege.consmatt.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.consmatt.beans.Task;


@Repository
public class TaskRepository { //Class starts

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addTask(Task task) { //Method used to insert data from the addTask HTML form into the tasks SQL database
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO tasks (name, lenght, day) VALUES (:name, :lenght, :day)"; 
		parameters.addValue("name", task.getName());
		parameters.addValue("lenght", task.getLenght());
		parameters.addValue("day", task.suggestion);
		jdbc.update(query, parameters);
	} //Method ends
	
	
	//--------------------Anything within these lines are used to add data to the tables depending on their respective day of the week-----------------
	
	public ArrayList<Task> getTaskMonday() { //Method used to display information from tasks SQL database based on their respective days
		ArrayList<Task> tasks = new ArrayList<Task>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM tasks WHERE day ='Monday'"; //This chooses the rows with the specific day
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row: rows) {
			Task d = new Task();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setLenght((Double)row.get("lenght"));
			d.setDay((String)row.get("day"));
			tasks.add(d);
		}
		return tasks;
	} //Method ends
	
	public ArrayList<Task> getTaskTuesday() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM tasks WHERE day ='Tuesday'";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Task d = new Task();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setLenght((Double)row.get("lenght"));
			d.setDay((String)row.get("day"));
			tasks.add(d);
		}
		return tasks;
	} //Method ends
	
	public ArrayList<Task> getTaskWednesday() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM tasks WHERE day ='Wednesday'";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Task d = new Task();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setLenght((Double)row.get("lenght"));
			d.setDay((String)row.get("day"));
			tasks.add(d);
		}
		return tasks;
	}
	
	public ArrayList<Task> getTaskThursday() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM tasks WHERE day ='Thursday'";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Task d = new Task();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setLenght((Double)row.get("lenght"));
			d.setDay((String)row.get("day"));
			tasks.add(d);
		}
		return tasks;
	} //Method ends
	
	public ArrayList<Task> getTaskFriday() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM tasks WHERE day ='Friday'";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row: rows) {
			Task d = new Task();
			d.setId((Integer)row.get("id"));
			d.setName((String)row.get("name"));
			d.setLenght((Double)row.get("lenght"));
			d.setDay((String)row.get("day"));
			tasks.add(d);
		}
		return tasks;
	} //Method ends
	

	
	
//-----------------------------------------------------------End of "card" table methods---------------------------------------------------------------

	
	
} //Class ends

