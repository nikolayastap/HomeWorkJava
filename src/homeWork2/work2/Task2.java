package homeWork2.work2;

/*
Сортировка пузырьком с логированием
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой
итерации запишите в лог-файл. Напишите свой код в методе sort класса BubbleSort. Метод
sort принимает на вход один параметр: int[] arr - числовой массив
После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' в
формате год-месяц-день час:минуты {массив на данной итерации}. Для логирования
использовать логгер logger класса BubbleSort.
Пример:
arr = new int[]{9, 4, 8, 3, 1};
sort(arr)

// При чтении лог-файла получим:
2023-05-19 07:53 [4, 8, 3, 1, 9]
2023-05-19 07:53 [4, 3, 1, 8, 9]
2023-05-19 07:53 [3, 1, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
*/

//public class Task2 {

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;

    public static String logger() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = dateFormat.format(new Date());
        return formattedDate;
    }

    public static void sort(int[] mas) {
        try {
            log = new File("log.txt");
            fileWriter = new FileWriter(log);
            bufferedWriter = new BufferedWriter(fileWriter);
            boolean swapped;
            for (int i = 0; i < mas.length; i++) {
                swapped = false;
                for (int j = 0; j < mas.length - 1 - i; j++) {
                    if (mas[j] > mas[j + 1]) {
                        int temp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (swapped == false)
                    break;
                bufferedWriter.write(logger() + " " + Arrays.toString(mas));
                bufferedWriter.write(System.lineSeparator());
            }
            bufferedWriter.write(logger() + " " + Arrays.toString(mas));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//}
