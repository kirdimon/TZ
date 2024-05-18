package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class NumberProcessor {

    public static void main(String[] args) {
        // Абсолютный путь к файлу для отладки
        String filePath = "C:\\JavaProject\\NumberProcessor\\numbers.txt";

        // Вывод текущего рабочего каталога
        System.out.println("Текущий рабочий каталог: " + System.getProperty("user.dir"));

        try {
            int[] numbers = readNumbersFromFile(filePath);

            System.out.println("Минимальное: " + _min(numbers));
            System.out.println("Максимальное: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static int[] readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int _min(int[] numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    public static int _max(int[] numbers) {
        return Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
    }

    public static int _sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static long _mult(int[] numbers) {
        long product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }
}
