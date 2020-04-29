package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.start();
    }

    private void start() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число 1: ");
        double digit1 = in.nextDouble();
        System.out.print("Введите операцию (сложение \"+\", вычитание \"-\", умножение \"*\"" +
                ", возведение в степень \"^\", факториал \"!\", числа Фибоначчи \"f\"): ");
        String operation = in.next();
        try {
            switch (operation) {
                case "!": {
                    FactorialOperation fo = new FactorialOperation();
                    System.out.print("Результат: " + fo.calculate(digit1));
                    return;
                }
                case "f": {
                    FibonachchiOperation fo = new FibonachchiOperation();
                    System.out.print("Результат: " + fo.calculate(digit1));
                    return;
                }
            }
            System.out.print("Введите число 2: ");
            double digit2 = in.nextDouble();
            switch (operation) {
                case "+":
                    AdditionalOperation ao = new AdditionalOperation();
                    System.out.print("Результат: " + ao.calculate(digit1, digit2));
                    break;
                case "-":
                    SubstractionOperation so = new SubstractionOperation();
                    System.out.print("Результат: " + so.calculate(digit1, digit2));
                    break;
                case "*":
                    MultiplicationOperation mo = new MultiplicationOperation();
                    System.out.print("Результат: " + mo.calculate(digit1, digit2));
                    break;
                case "^":
                    ExponentiationOperation eo = new ExponentiationOperation();
                    System.out.print("Результат: " + eo.calculate(digit1, digit2));
                    break;
                default:
                    System.out.print("Данная операция не поддерживается. Программа будет закрыта");
                    break;
            }
        } catch (InputMismatchException ex) {
            System.out.println("Необходимо ввести цифру. Попробуйте еще раз");
        }
        in.close();
    }

}
