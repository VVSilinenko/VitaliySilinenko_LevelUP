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
        PassengerPlane shortRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 1", 2500,750, 250000, 120, 2);
        PassengerPlane midRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 2", 6000, 800, 500000, 220, 2);
        PassengerPlane longRangeAirPlane = new PassengerAirPlane("Пассажирский самолет 3", 9000, 900, 1000000, 450, 4);

        // Создаем грузовые самолеты
        CargoPlane cargoAirPlane_1 = new CargoAirPlane("Грузовой самолет 1", 3000, 800, 620000, 20000, 2);
        CargoPlane cargoAirPlane_2 = new CargoAirPlane("Грузовой самолет 2",5000, 800, 450000, 18000,  4);
        CargoPlane cargoAirPlane_3 = new CargoAirPlane("Грузовой самолет 3",8000, 900, 1200000, 50000, 4);

        // Создаем пассажирские вертолеты
        PassengerPlane passengerRotorPlane_1 = new PassengerRotorPlane("Пассажирский вертолет 1", 300, 200, 150000, 20, 1);
        PassengerPlane passengerRotorPlane_2 = new PassengerRotorPlane("Пассажирский вертолет 2",250, 250, 120000, 15, 1);

        // Создаем грузовые вертолеты
        CargoPlane cargoRotorPlane_1 = new CargoRotorPlane("Грузовой вертолет 1",400, 300, 350000, 8000, 550);
        CargoPlane cargoRotorPlane_2 = new CargoRotorPlane("Грузовой вертолет 2",400, 320, 400000, 10000, 650);


        HashSet<PassengerPlane> passengerAirPark = new HashSet<>();
        passengerAirPark.add(shortRangeAirPlane);
        passengerAirPark.add(midRangeAirPlane);
        passengerAirPark.add(longRangeAirPlane);
        passengerAirPark.add(passengerRotorPlane_1);
        passengerAirPark.add(passengerRotorPlane_2);

        HashSet<CargoPlane> cargoAirPark = new HashSet<>();
        cargoAirPark.add(cargoAirPlane_1);
        cargoAirPark.add(cargoAirPlane_2);
        cargoAirPark.add(cargoAirPlane_3);
        cargoAirPark.add(cargoRotorPlane_1);
        cargoAirPark.add(cargoRotorPlane_2);

        HashSet<Plane> allPlane = new HashSet<>();
        allPlane.add(shortRangeAirPlane);
        allPlane.add(midRangeAirPlane);
        allPlane.add(longRangeAirPlane);
        allPlane.add(cargoAirPlane_1);
        allPlane.add(cargoAirPlane_2);
        allPlane.add(cargoAirPlane_3);
        allPlane.add(passengerRotorPlane_1);
        allPlane.add(passengerRotorPlane_2);
        allPlane.add(cargoRotorPlane_1);
        allPlane.add(cargoRotorPlane_2);

        // Сортировка летных средств по дальности полета
        sortByRangeOfFlight(allPlane);

        // Посчитаем общую вместимость пассажирских самолетов
        getPassengerCapacity(passengerAirPark);

        // Посчитаем общую грузоподъемность грузовых самолетов
        getCargoCapacity(cargoAirPark);

        // Посчитаем общую стоимость всего авиапарка
        getCountPrice(allPlane);

    }

    private static void sortByRangeOfFlight(HashSet<Plane> planes){
        System.out.println("Сортировка летных средств по дальности полета:");
        Iterator<Plane> i = planes.iterator();

        ArrayList<Plane> list = new ArrayList<>();
        int y = 0;
        while (i.hasNext()) {
            list.add(y, i.next());
        }
        Comparator<Plane> sortByRange = new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return (int) o1.getMaxRangeOfFlight() - (int) o2.getMaxRangeOfFlight();
            }
        };
        list.sort(sortByRange);
        for (int a = 0; a < list.size(); a++){
            System.out.println(list.get(a).getName() + ": " + list.get(a).getMaxRangeOfFlight());
        }
        System.out.println("=========================");
    }

    private static void getCountPrice(HashSet<Plane> countPrice) {
        Iterator<Plane> i = countPrice.iterator();

        ArrayList<Double> totalPrice = new ArrayList<>();
        int y = 0;
        while (i.hasNext()) {
            totalPrice.add(y, i.next().getPrice());
        }
        double count = totalPrice.get(0);
        for (int a = 1; a < totalPrice.size(); a++){
            count = count + totalPrice.get(a);
        }

        System.out.println("Общая стоимость авиапарка: " + count + " $");
        System.out.println("=========================");
    }

    private static void getCargoCapacity(HashSet<CargoPlane> cargoAirPark) {
        Iterator<CargoPlane> i = cargoAirPark.iterator();

        ArrayList<Double> countCapacity = new ArrayList<>();
        int y = 0;
        while (i.hasNext()) {
            countCapacity.add(y, i.next().getCarryingCapacity());
        }
        double count = countCapacity.get(0);
        for (int a = 1; a < countCapacity.size(); a++){
            count = count + countCapacity.get(a);
        }

        System.out.println("Общая грузоподъемность авиапарка: " + count + " кг.");
        System.out.println("=========================");
    }

    private static void getPassengerCapacity(HashSet<PassengerPlane> airPark){
        Iterator<PassengerPlane> i = airPark.iterator();

        ArrayList<Integer> countCapacity = new ArrayList<Integer>();
        int y = 0;
        while (i.hasNext()) {
            countCapacity.add(y, i.next().getCapacity());
        }
        int count = countCapacity.get(0);
        for (int a = 1; a < countCapacity.size(); a++){
            count = count + countCapacity.get(a);
        }

        System.out.println("Общая вместимость авиапарка: " + count + " человек");
        System.out.println("=========================");
    }
}
