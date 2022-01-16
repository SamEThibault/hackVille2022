package ca.sheridancollege.consmatt.beans;

public class Avail {

    public String day;
    public int time;
    public boolean occupied;

    public Avail(String Day, int Time)
    {
        day = Day;
        time = Time;
        occupied = false;
    }
}
