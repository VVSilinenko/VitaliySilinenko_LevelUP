package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo;

public class CargoAirPlane extends CargoPlane {

    // Кол-во двигателей
    private int countEngine;

    public CargoAirPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1, double carryingCapacity, int countEngine) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1, carryingCapacity);
        this.countEngine = countEngine;
    }

    public int getCountEngine() {
        return countEngine;
    }

    public void setCountEngine(int countEngine) {
        this.countEngine = countEngine;
    }

}
