package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo;

public class CargoRotorPlane extends CargoPlane {

    private double maxHeight;

    public CargoRotorPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1, double carryingCapacity, double maxHeight) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1, carryingCapacity);
        this.maxHeight = maxHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

}

