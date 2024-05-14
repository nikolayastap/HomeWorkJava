package homeWork1.work1;

/*
Напишите функцию printPrimeNums, которая выведет на экран все
простые числа в промежутке от 1 до 1000, каждое на новой строке.
 */
public class Task2 {

    public static void printPrimeNums() {
        for (int i = 2; i < 1000; i++) {
            boolean flag = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0 && i != j) {
                    flag = false;
                    j = i / 2;
                }
            }
            if (flag) System.out.println(i);
        }

        /*
        Решение от студента
        String rez = 0;
        int count = 0;
        for (int i = 2; i < 1000; i++) {
            for (int k = i -1; k >= 1; k--){
                if (i % k == 0 && k % 1) {
                    break;
                } else if (i % k == 0 && k == 1) {
                    rez += " " + i;
                    count++;
                    if (count == 10) {
                        System.out.println(rez);
                        rez = "";
                        count = 0;
                    }
                }
            }
        }
         */
    }
}