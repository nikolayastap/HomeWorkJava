package homeWork1.work1;

import java.util.Scanner;

/*
В методе calculate класса Calculator реализовать калькулятор,
который будет выполнять математические операции (+, -, *, /)над
двумя целыми числами и возвращать результат вещественного типа.

В классе Printer необходимо реализовать проверку переданного
оператора, при некорректном операторе программа должна вывести
сообщение об ошибке "Некорректный оператор: 'оператор'".
 */
public class Task3 {
    public static void calculate() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число a: ");
        double a = scanner.nextDouble();
        System.out.print("Укажите арифметическую операцию: ");
        char op = scanner.next().charAt(0);
        System.out.print("Введите число b: ");
        double b = scanner.nextDouble();

        double result = 0;
        if (op == '+') result = a + b;
        else if (op == '-') result = a - b;
        else if (op == '*') result = a * b;
        else if (op == '/') result = a / b;
        else {
            System.out.println("Неправильный оператор");
        }

        System.out.println("Результат: " + result);
    }
}