package ca.sheridancollege.consmatt.beans;

import java.io.Serializable;
import java.util.ArrayList;


import ca.sheridancollege.consmatt.logic.Availability;
import ca.sheridancollege.consmatt.logic.Tasks;
import ca.sheridancollege.consmatt.repositories.TaskRepository;

import ca.sheridancollege.consmatt.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable { //Class starts, implements Serializable but TBH IDFK why, it doesn't seem to matter though

	private static final long serialVersionUID = -3258943135795152638L;

	private int id;  //Creation of Constructors for Bean, Getters and Setters are created using Lombok
	private String name;
	private double lenght;
	private String day;
	public String suggestion;
	

	static ArrayList<Time> times = new ArrayList<Time>();
	
	@Autowired
	private TimeRepository timeRepo; 
	
	
	public String setDay() {
		
		//create instance of TimeRepository to get access to hour availability
		//getMonday and so on methods are used for
		TimeRepository availability = new TimeRepository();
		TaskRepository task = new TaskRepository();

		return day;
	}

}
