package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

public class FibonachchiOperation {

    long calculate(double digit1) {
        int digit = (int) digit1;
        if (digit < 0) {
            System.out.println("Введено отрицательное число. Оно будет преобразовано в положительное");
            digit = Math.abs(digit);
        }
        System.out.println("Будет показано число Фибоначчи под номером \"" + digit + "\"");
        if (digit == 0 || digit == 1) {
            return digit;
        } else {
            long a = 0;
            long b = 1;
            for (int i = 2; i <= digit; ++i) {
                long next = a + b;
                a = b;
                b = next;
            }
            return b;
        }
    }
}
