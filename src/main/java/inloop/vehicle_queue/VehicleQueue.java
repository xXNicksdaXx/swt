package inloop.vehicle_queue;

import java.util.Deque;

public class VehicleQueue implements ClockObserver {
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private boolean greenLight = false;
    private VehicleGenerator generator;
    private Deque<Vehicle> queue;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator){
        if(entryDelay <= 0) throw new IllegalArgumentException("entryDelay should be positive!");
        if(exitDelay <= 0) throw new IllegalArgumentException("exitDelay should be positive!");
        if(trafficLightRate <= 0) throw new IllegalArgumentException("trafficLightRate should be positive!");
        if(generator == null) throw new NullPointerException("generator cannot be null!");

        this.entryDelay = entryDelay;
        this.exitDelay = exitDelay;
        this.trafficLightRate = trafficLightRate;
        this.generator = generator;
    }

    public void enter(){
        Vehicle vehicle = generator.createVehicle();
        queue.push(vehicle);
    }

    public void leave(){
        queue.pop();
    }

    public double getLength(){
        return queue.size();
    }

    public int getSize(){
        return 0;
    }

    @Override
    public void tick(int currentTime) {

    }
}
