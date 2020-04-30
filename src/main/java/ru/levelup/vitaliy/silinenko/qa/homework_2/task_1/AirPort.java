package ru.levelup.vitaliy.silinenko.qa.homework_2.task_1;

import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Plane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo.CargoAirPlane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo.CargoPlane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Cargo.CargoRotorPlane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger.PassengerAirPlane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger.PassengerPlane;
import ru.levelup.vitaliy.silinenko.qa.homework_2.task_1.Plane.Passenger.PassengerRotorPlane;

import java.util.*;

public class AirPort {

    public static void main(String[] args) {
        // Создаем пассажирские самолеты
        PassengerPlane shortRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 1", 2500,750, 250000, 2.5, 3.6, 120, 2);
        PassengerPlane midRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 2", 6000, 800, 500000, 5.3, 7.0, 220, 2);
        PassengerPlane longRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 3", 9000, 900, 1000000, 10.6, 3.6, 450, 4);

        // Создаем грузовые самолеты
        CargoPlane cargoAirPlane_1 = new CargoAirPlane("Грузовой самолет 1", 3000, 800, 620000, 3.7, 2.9, 20000, 2);
        CargoPlane cargoAirPlane_2 = new CargoAirPlane("Грузовой самолет 2",5000, 800, 450000, 8,1.5, 18000,  4);
        CargoPlane cargoAirPlane_3 = new CargoAirPlane("Грузовой самолет 3",8000, 900, 1200000, 3, 7.7, 50000, 4);

        // Создаем пассажирские вертолеты
        PassengerPlane passengerRotorPlane_1 = new PassengerRotorPlane("Пассажирский вертолет 1", 300, 200, 150000, 2.8, 1.9, 20, 1);
        PassengerPlane passengerRotorPlane_2 = new PassengerRotorPlane("Пассажирский вертолет 2",250, 250, 120000, 6.9, 9.2, 15, 1);

        // Создаем грузовые вертолеты
        CargoPlane cargoRotorPlane_1 = new CargoRotorPlane("Грузовой вертолет 1",400, 300, 350000,  4.6, 2.8, 8000, 550);
        CargoPlane cargoRotorPlane_2 = new CargoRotorPlane("Грузовой вертолет 2",400, 320, 400000, 7, 9, 10000, 650);


        List<PassengerPlane> passengerAirPark;
        passengerAirPark = Arrays.asList(shortRangeAirPlane,midRangeAirPlane,longRangeAirPlane,passengerRotorPlane_1,
                passengerRotorPlane_2);

        List<CargoPlane> cargoAirPark;
        cargoAirPark = Arrays.asList(cargoAirPlane_1,cargoAirPlane_2,cargoAirPlane_3,cargoRotorPlane_1,
                cargoRotorPlane_2);

        List<Plane> allPlane;
        allPlane = Arrays.asList(shortRangeAirPlane,midRangeAirPlane,longRangeAirPlane,cargoAirPlane_1,cargoAirPlane_2,
                cargoAirPlane_3,passengerRotorPlane_1,passengerRotorPlane_2,cargoRotorPlane_1,cargoRotorPlane_2);

        passengerRotorPlane_1.flight(10, 10.9);

        // Сортировка летных средств по дальности полета
        sortByRangeOfFlight(allPlane);

        // Посчитаем общую вместимость пассажирских самолетов
        getPassengerCapacity(passengerAirPark);

        // Посчитаем общую грузоподъемность грузовых самолетов
        getCargoCapacity(cargoAirPark);

        // Посчитаем общую стоимость всего авиапарка
        getCountPrice(allPlane);



    }

    private static void sortByRangeOfFlight(List<Plane> planes){
        System.out.println("Сортировка летных средств по дальности полета:");

        Comparator<Plane> sortByRange = Comparator.comparingInt(o -> (int) o.getMaxRangeOfFlight());
        planes.sort(sortByRange);
        for (Plane plane : planes) {
            System.out.println(plane.getMaxRangeOfFlight());
        }
        System.out.println("=========================");
    }

    private static void getCountPrice(List<Plane> countPrice) {

        double count = countPrice.get(0).getPrice();
        for (int a = 1; a < countPrice.size(); a++){
            count += countPrice.get(a).getPrice();
        }

        System.out.println("Общая стоимость авиапарка: " + count + " $");
        System.out.println("=========================");
    }

    private static void getCargoCapacity(List<CargoPlane> countCapacity) {

        double count = countCapacity.get(0).getCarryingCapacity();
        for (int a = 1; a < countCapacity.size(); a++){
            count += countCapacity.get(a).getCarryingCapacity();
        }

        System.out.println("Общая грузоподъемность авиапарка: " + count + " кг.");
        System.out.println("=========================");
    }

    private static void getPassengerCapacity(List<PassengerPlane> countCapacity){

        int count = 0;
        for (PassengerPlane passengerPlane : countCapacity) {
            count += passengerPlane.getCapacity();
        }

        System.out.println("Общая вместимость авиапарка: " + count + " человек");
        System.out.println("=========================");
    }
}
