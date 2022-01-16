package ca.sheridancollege.consmatt.logic;

import ca.sheridancollege.consmatt.beans.Time;

import java.util.ArrayList;

public class Availability {
    int time;
    boolean occupied;
    String day;

    public Availability(int Time, String Day)
    {
        time = Time;
        day = Day;
    }
}

