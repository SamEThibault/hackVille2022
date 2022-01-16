package ca.sheridancollege.consmatt.logic;

import ca.sheridancollege.consmatt.beans.Time;
import ca.sheridancollege.consmatt.repositories.TimeRepository;

import java.util.ArrayList;

public class Logic {


    public void Output()
    {
        TimeRepository repoInstance = new TimeRepository();
        ArrayList<Time> arrayList = repoInstance.getTime();

        ArrayList<Integer> newList = new ArrayList<Integer>(arrayList.size());

        for (Time i : arrayList)
        {
            newList.add(Integer.valueOf(String.valueOf(i)));
        }

        for (int i = 0; i < newList.size(); i++)
        {
            System.out.println(newList.get(i));
        }
    }
}
