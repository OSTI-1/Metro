package com.example.metro;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void testMainWithValidInput() {
        // Подготовка ввода (эмулируем ввод пользователя: стартовая и конечная станции)
        String input = "0\n5\n"; // Пользователь вводит 0 и 5 (станции метро)
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Перехватываем вывод в консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаем метод main
        App.main(new String[]{});

        // Проверяем, что вывод содержит ожидаемую строку
        String output = outContent.toString();
        assertTrue(output.contains("Shortest path"), "Output should contain 'Shortest path'");
        assertTrue(output.contains("Total travel time"), "Output should contain 'Total travel time'");

        // Возвращаем стандартные потоки
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainWithInvalidInput() {
        // Подготовка ввода (неверные станции)
        String input = "72\n-1\n"; // Пользователь вводит некорректные номера станций
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Перехватываем вывод в консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаем метод main
        App.main(new String[]{});

        // Проверяем, что вывод содержит сообщение об ошибке
        String output = outContent.toString();
        assertTrue(output.contains("Invalid station number"), "Output should contain 'Invalid station number'");

        // Возвращаем стандартные потоки
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
