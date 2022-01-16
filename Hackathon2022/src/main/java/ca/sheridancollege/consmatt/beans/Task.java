package ca.sheridancollege.consmatt.beans;

import java.io.Serializable;

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
}
