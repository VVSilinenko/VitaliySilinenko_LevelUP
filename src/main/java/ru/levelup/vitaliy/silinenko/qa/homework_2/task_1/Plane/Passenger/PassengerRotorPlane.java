package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger;

public class PassengerRotorPlane extends PassengerPlane {

    // Кол-во винтов
    private int countRotor;

    public PassengerRotorPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, int capacity, int countRotor) {
        super(name, maxRangeOfFlight, maxSpeed, price, capacity);
        this.countRotor = countRotor;
    }

    public int getCountRotor() {
        return countRotor;
    }

    public void setCountRotor(int countRotor) {
        this.countRotor = countRotor;
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
