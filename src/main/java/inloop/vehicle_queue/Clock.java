package inloop.vehicle_queue;

import java.util.HashSet;
import java.util.Set;

public class Clock {
    private int currentTime = 0;
    private int endOfTime;
    private Set<ClockObserver> observers;

    public Clock(int endOfTime){
        if(endOfTime <= 0) throw new IllegalArgumentException("endOfTime should be positive!");
        this.endOfTime = endOfTime;
        observers = new HashSet<>();
    }

    public void addObserver(ClockObserver observer){
        if(observer == null) throw new NullPointerException("observer cannot be null!");
        observers.add(observer);
    }

    public void removeObserver(ClockObserver observer){
        if(observer == null) throw new NullPointerException("observer cannot be null!");
        observers.remove(observer);
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void run(){
        while(currentTime < endOfTime){
            currentTime++;
            tick(currentTime);
        }
    }

    private void tick(int currentTime){
        for(ClockObserver observer : observers){
            observer.tick(currentTime);
        }
    }
}
