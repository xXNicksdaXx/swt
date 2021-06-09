package inloop.event_app;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute){
        if(hour < 0 || hour > 23) throw new IllegalArgumentException("hour must be between 0-23!");
        if(minute < 0 || minute > 59) throw new IllegalArgumentException("minute must be between 0-59!");
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
