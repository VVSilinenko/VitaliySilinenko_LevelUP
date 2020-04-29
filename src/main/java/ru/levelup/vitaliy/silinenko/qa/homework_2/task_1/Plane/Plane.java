package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane;

public abstract class Plane implements Flight {

    private double maxRangeOfFlight;
    private double maxSpeed;
    private double price;
    private String name;

    public Plane(String name, double maxRangeOfFlight, double maxSpeed, double price) {
        this.name = name;
        this.maxRangeOfFlight = maxRangeOfFlight;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxRangeOfFlight() {
        return maxRangeOfFlight;
    }

    public void setMaxRangeOfFlight(double maxRangeOfFlight) {
        this.maxRangeOfFlight = maxRangeOfFlight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
