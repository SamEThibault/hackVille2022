package ca.sheridancollege.consmatt.logic;

import ca.sheridancollege.consmatt.beans.Avail;
import ca.sheridancollege.consmatt.beans.Task;
import ca.sheridancollege.consmatt.beans.Time;
import ca.sheridancollege.consmatt.repositories.TimeRepository;

import javax.swing.tree.RowMapper;
import java.util.ArrayList;

public class Logic{

    public Task task;
    public Avail[] availArray;

    int count = 0;

    // constructor
    public Logic(Task Task, Avail[] AvailArray)
    {
        task = Task;
        availArray = AvailArray;

    }

    public String Output()
    {
        // switch case to alter how far ahead in the week we can assign the task (the date variable)
        int date;

        switch (task.getDay()) {
            case "Monday" -> date = 1;
            case "Tuesday" -> date = 2;
            case "Wednesday" -> date = 3;
            case "Thursday" -> date = 4;
            case "Friday", "NONE" -> date = 5;
            default -> {
                date = 0;
                System.out.println("ERROR: INVALID DUE DATE");
            }
        }


        // for each day of the work week
        outer: for (int j = 0; j < date; j++)
        {
            // task time compared with avail time, if day is not fully booked and can accommodate task, suggest that
            // day to complete it.

            // need to do a check to see if the task time is identical to one of the week time slots BEFORE checking
            // for less ideal slots, if there's one, instantly set to occupied and break loop.
            if (j == 0)
            {
                // on first outer loop iteration (first day of the week), check all days to see if there's a
                // perfect time slot for the analyzed task. If there is, set it to that day before anything else,
                // and break outer loop to check next task.
                int k = 0;
                while (k < date)
                {
                    if (task.getLenght() == availArray[k].time)
                    {
                        availArray[k].time = 0; // if the avail time is equal to task time, implies day is filled
                        availArray[k].occupied = true;
                        task.suggestion = availArray[k].day; // suggest that day for the task
                        break outer;
                    }
                    k++;
                }
            }

            if (((task.getLenght()) < availArray[j].time) && !availArray[j].occupied)
            {
                // populate suggestion day field for task
                task.suggestion = availArray[j].day;
                availArray[j].time -= task.getLenght(); // avail time gets updated to reflect new task add.

                if (availArray[j].time == 0) // if the day is fully booked, update occupied bool
                {
                    availArray[j].occupied = true;
                }
                break;
            }
        }

        // for debugging
        if (task.suggestion != null)
        {
            System.out.println("We suggest completing " + task.getName() + " on: " + task.suggestion);
        }
        else
        {
            System.out.println("UNABLE TO ALLOCATE TIME FOR TASK!!!");
        }

        return task.suggestion;
    }
}

