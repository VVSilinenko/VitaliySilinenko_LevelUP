package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger;

import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Plane;

public abstract class PassengerPlane extends Plane {

    private int capacity;

    public PassengerPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1, int capacity) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
