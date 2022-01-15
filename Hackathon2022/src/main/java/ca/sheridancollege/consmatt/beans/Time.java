package ca.sheridancollege.consmatt.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time implements Serializable { //Class starts

	private static final long serialVersionUID = -3262133248341520792L;
	
	private String monday; //Creation of Constructors for Bean, Getters and Setters are created using Lombok
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
} //Class ends
