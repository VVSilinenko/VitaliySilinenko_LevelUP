package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger;

public class PassengerRotorPlane extends PassengerPlane {

    // Кол-во винтов
    private int countRotor;

    public PassengerRotorPlane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1, int capacity, int countRotor) {
        super(name, maxRangeOfFlight, maxSpeed, price, x1, y1, capacity);
        this.countRotor = countRotor;
    }

    public int getCountRotor() {
        return countRotor;
    }

    public void setCountRotor(int countRotor) {
        this.countRotor = countRotor;
    }

}
