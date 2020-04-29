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
        System.out.print("Введите число (целое или с плавающей точкой): ");
        double digit = in.nextDouble();
        System.out.print("Введите операцию (сложение \"+\", вычитание \"-\", умножение \"*\"" +
                ", возведение в степень \"^\", факториал \"!\", числа Фибоначчи \"f\"): ");
        String operation = in.next();
        try {
            if (operation.equals("+")) {
                AdditionalOperation ao = new AdditionalOperation();
                ao.calculate(in, digit);
            } else if (operation.equals("-")) {
                SubstractionOperation so = new SubstractionOperation();
                so.calculate(in, digit);
            } else if (operation.equals("*")) {
                MultiplicationOperation mo = new MultiplicationOperation();
                mo.calculate(in,digit);
            } else if (operation.equals("^")) {
                ExponentiationOperation eo = new ExponentiationOperation();
                eo.calculate(in, digit);
            } else if (operation.equals("!")) {
                System.out.println("Если введено число с плавающей точкой, то оно будет округлено в меньшую сторону");
                FactorialOperation fo = new FactorialOperation();
                fo.calculate(in, (int) digit);
            } else if (operation.equals("f")) {
                System.out.println("Если введено число с плавающей точкой, то оно будет округлено в меньшую сторону");
                FibonachchiOperation fo = new FibonachchiOperation();
                fo.calculate(in, (int) digit);
            } else {
                System.out.print("Данная операция не поддерживается. Программа будет закрыта");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Необходимо ввести цифру. Попробуйте еще раз");
        }
        in.close();
    }

}
