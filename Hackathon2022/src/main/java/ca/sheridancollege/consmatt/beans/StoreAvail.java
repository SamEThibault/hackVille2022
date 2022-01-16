package ca.sheridancollege.consmatt.beans;

public class StoreAvail {
    Avail mon = new Avail("Monday", 0);
    Avail tue = new Avail("Tuesday", 2);
    Avail wed = new Avail("Wednesday", 2);
    Avail thu = new Avail("Thursday", 2);
    Avail fri = new Avail("Friday", 2);

    Avail[] availArray = {mon, tue, wed, thu, fri};

    public Avail[] out()
    {
        return availArray;
    }
}
