package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class RecordWork {

    private String name;
    private int hoursWork;
    private LocalDate date;

    public RecordWork(String name, int hoursWork, LocalDate date) {
        this.name = name;
        this.hoursWork = hoursWork;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getHoursWork() {
        return hoursWork;
    }

    public LocalDate getDate() {
        return date;
    }
}
