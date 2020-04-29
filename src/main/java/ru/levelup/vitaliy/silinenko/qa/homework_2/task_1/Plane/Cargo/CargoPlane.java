package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo;

import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Plane;

public abstract class CargoPlane extends Plane {

    private double carryingCapacity;

    public CargoPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double carryingCapacity) {
        super(name, maxRangeOfFlight, maxSpeed, price);
        this.carryingCapacity = carryingCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
