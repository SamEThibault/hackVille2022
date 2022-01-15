package ca.sheridancollege.consmatt.logic;

// how this shit is gonna work:
// instantiate logic object with 2 attributes: a task object, and an array of availability objects.
public class Logic {

    Tasks task;
    Availability[] availArray;

    // constructor
    public Logic (Tasks tA, Availability[] aA)
    {
        task = tA;
        availArray = aA;
    }

    public void Output ()
    {
        // program logic to compare availability with Tasks instances

            // switch case to alter how far ahead in the week we can assign the task (the date variable)
            int date;

            switch (task.dueDate) {
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
                        if (task.timeRequired == availArray[k].time)
                        {
                            availArray[k].time = 0; // if the avail time is equal to task time, implies day is filled
                            availArray[k].occupied = true;
                            task.suggestion = availArray[k].day; // suggest that day for the task
                            break outer;
                        }
                        k++;
                    }
                }

                if ((task.timeRequired < availArray[j].time) && !availArray[j].occupied)
                {
                    task.suggestion = availArray[j].day; // populate suggestion day field for task
                    availArray[j].time -= task.timeRequired; // avail time gets updated to reflect new task add.

                    if (availArray[j].time == 0) // if the day is fully booked, update occupied bool
                    {
                        availArray[j].occupied = true;
                    }
                    break;
                }
            }

            System.out.println("We suggest completing " + task.taskName + " on: " + task.suggestion);
            // to debug check
    }
}

