package ca.sheridancollege.consmatt.logic;

public class Tasks
{
    String taskName;
    int timeRequired;
    String suggestion;
    String dueDate;

    public Tasks(int Time, String Name, String Due)
    {
        timeRequired = Time;
        taskName = Name;
        dueDate = Due;
        suggestion = "NO TIME SLOT AVAILABLE"; // default

    }
}
