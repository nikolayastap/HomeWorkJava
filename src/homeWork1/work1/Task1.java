package homeWork1.work1;

import java.util.Scanner;

/*
Вычислить n-ое треугольного число(сумма чисел от 1 до n).
Внутри класса Answer напишите метод countNTriangle, который принимает
число n и возвращает его n-ое треугольное число.
Если число n < 1 (ненатуральное) метод должен вернуть -1.
*/
public class Task1 {
    public static void nTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        int result = sum(n);
        System.out.println(result);
    }
    public static int sum(int n) {
        if (n < 1) return -1;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
}