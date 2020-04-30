package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane;

public abstract class Plane implements Flight {

    private double maxRangeOfFlight;
    private double maxSpeed;
    private double price;
    private String name;
    private double x1;
    private double y1;

    public Plane(String name, double maxRangeOfFlight, double maxSpeed, double price, double x1, double y1) {
        this.name = name;
        this.maxRangeOfFlight = maxRangeOfFlight;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.x1 = x1;
        this.y1 = y1;
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

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    @Override
    public void flight(double x2, double y2) {
        if (x2 == getX1() && y2 == getY1()){
            System.out.println("Координаты воздушного судна совпадают с координатами места назначения");
            return;
        }
        double step = 0.2;
        if (x2 > getX1()) {
            while (x2 > getX1()) {
                setX1(getX1() + step);
            }
        } else if (x2 < getX1()) {
            while (x2 < getX1()) {
                setX1(getX1() - step);
            }
        }
        if (y2 > getY1()) {
            while (y2 > getY1()) {
                setY1(getY1() + step);
            }
        } else if (y2 < getY1()) {
            while (y2 < getY1()) {
                setY1(getY1() - step);
            }
        }

        System.out.println("Воздушное судно прибыло в место назначения с координатами: x = " + getX1() + " || y = " + getY1());
        System.out.println("========================");

    }
}
