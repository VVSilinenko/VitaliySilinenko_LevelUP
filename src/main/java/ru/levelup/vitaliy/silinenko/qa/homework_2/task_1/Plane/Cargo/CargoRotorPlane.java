package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo;

public class CargoRotorPlane extends CargoPlane {

    private double maxHeight;

    public CargoRotorPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double carryingCapacity, double maxHeight) {
        super(name, maxRangeOfFlight, maxSpeed, price, carryingCapacity);
        this.maxHeight = maxHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }


    @Override
    public void takeoff() {

    }

    @Override
    public void flight(double x2, double y2) {

    }

    @Override
    public void landing(double landingSpeed) {

    }
}

