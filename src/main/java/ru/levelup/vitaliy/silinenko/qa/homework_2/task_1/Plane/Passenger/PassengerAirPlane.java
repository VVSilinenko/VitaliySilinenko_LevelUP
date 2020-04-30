package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger;

public class PassengerAirPlane extends PassengerPlane {

    // Кол-во двигателей
    private int countEngine;

    public PassengerAirPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1, int capacity, int countEngine) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1, capacity);
        this.countEngine = countEngine;
    }

    public int getCountEngine() {
        return countEngine;
    }

    public void setCountEngine(int countEngine) {
        this.countEngine = countEngine;
    }

}
