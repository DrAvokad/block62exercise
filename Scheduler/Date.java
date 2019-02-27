package Scheduler;

/**
 * Created by Niklas on 2016-02-26.
 */
public class Date {
    private final int year;
    private final int month;
    private final int day;


    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(Date date) {
        this.year = date.getYear();
        this.month = date.getMonth();
        this.day = date.getDay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (year != date.year) return false;
        if (month != date.month) return false;
        return day == date.day;

    }

/*

    @Override
    public boolean equals(Date o) {
        if (o == null) return false;

        if (year != date.year) return false;
        if (month != date.month) return false;
        return day == date.day;

    }

     */

    @Override
    public int hashCode() {
        return 0;
    }

/*
    public int hashCode() {
        return super.hashCode();
    }

    public int hashCode() {
        return (int)Math.random();
    }

    public int hashCode() {
        int hash = 0;
        hash += day;
        hash += month * 12;
        hash += year * 365;
        return hash;
    }
     */

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public int getYear() {
        return year;
    }

    public Date changeYear(int year) {
        return new Date(year,this.month,this.day);
    }

    public int getMonth() {
        return month;
    }

    public Date changeMonth(int month) {
        return new Date(this.year,month,this.day);
    }

    public int getDay() {
        return day;
    }

    public Date changeDay(int day) {
      return new Date(this.year,this.month,day);
    }
}