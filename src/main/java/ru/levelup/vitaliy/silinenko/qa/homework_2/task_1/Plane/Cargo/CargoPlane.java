package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo;

import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Plane;

public abstract class CargoPlane extends Plane {

    private double carryingCapacity;

    public CargoPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1,  double carryingCapacity) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1);
        this.carryingCapacity = carryingCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
