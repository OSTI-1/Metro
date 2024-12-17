package com.example.metro;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Главный класс приложения для расчета минимального времени пути между станциями метро.
 * Содержит методы для установки времени путешествия между станциями,
 * поиска индекса станции по названию и взаимодействия с пользователем.
 */

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());  // Инициализация логгера
    private static final String[] stationNames = {
            "Девяткино", "Гражданский проспект", "Академическая", "Политехническая",
            "Площадь Мужества", "Лесная", "Выборгская", "Площадь Ленина", "Чернышевская",
            "Площадь восстания", "Владимирская", "Пушкинская", "Технологический институт 1",
            "Балтийская", "Нарвская", "Кировский завод", "Автово", "Ленинский проспект",
            "Проспект ветеранов", "Парнас", "Проспект просвещения", "Озерки", "Удельная",
            "Пионерская", "Черная речка", "Петроградская", "Горьковская", "Невский проспект",
            "Сенная площадь", "Технологический институт 2", "Фрунзенская", "Московские ворота",
            "Электросила", "Парк победы", "Московская", "Звездная", "Купчино", "Беговая",
            "Зенит", "Приморская", "Василеостровская", "Гостиный двор", "Маяковская",
            "Площадь Александра Невского 1", "Елизаровская", "Ломоносовская", "Пролетарская",
            "Обухово", "рыбацкое", "Улица Дыбенко", "Проспект большевиков", "Ладожская",
            "Новочеркасская", "Площадь Александра Невского 2", "Лиговский проспект", "Достоевская",
            "Спасская", "Комендантский проспект", "Старая деревня", "Крестовский остров",
            "Чкаловская", "Спортивная", "Адмиралтейская", "Садовая", "Звенигородская",
            "Обводный канал", "Волковская", "Бухарестская", "Международная", "Проспект славы",
            "Дунайская", "Шушары"
    };

    /**
     * Основной метод приложения, который выполняет взаимодействие с пользователем,
     * запрашивает станции и выводит минимальное время путешествия между ними.
     *
     * @param args Аргументы командной строки (не используются).
     */

    public static void main(String[] args) {
        int numStations = stationNames.length;

        // Создание матрицы смежности
        int[][] adjacencyMatrix = new int[numStations][numStations];

        // Линия 1
        setTravelTime(adjacencyMatrix,0, 1, 3);  // Девяткино <-> Гражданский проспект
        setTravelTime(adjacencyMatrix,1, 2, 6);  // Гражданский проспект <-> Академическая
        setTravelTime(adjacencyMatrix,2, 3, 2);  // Академическая <-> Политехническая
        setTravelTime(adjacencyMatrix,3, 4, 3);  // Политехническая <-> Площадь Мужества
        setTravelTime(adjacencyMatrix,4, 5, 3);  // Площадь Мужества <-> Лесная
        setTravelTime(adjacencyMatrix,5, 6, 3);  // Лесная <-> Выборгская
        setTravelTime(adjacencyMatrix,6, 7, 2);  // Выборгская <-> Площадь Ленина
        setTravelTime(adjacencyMatrix,7, 8, 3);  // Площадь Ленина <-> Чернышевская
        setTravelTime(adjacencyMatrix,8, 9, 2);  // Чернышевская <-> Площадь Восстания
        setTravelTime(adjacencyMatrix,9, 10, 2);  // Площадь Восстания <-> Владимирская
        setTravelTime(adjacencyMatrix,10, 11, 2);  // Владимирская <-> Пушкинская
        setTravelTime(adjacencyMatrix,11, 12, 3);  // Пушкинская <-> Технологический институт 1
        setTravelTime(adjacencyMatrix,12, 13, 3);  // Технологический институт 1 <-> Балтийская
        setTravelTime(adjacencyMatrix,13, 14, 3);  // Балтийская <-> Нарвская
        setTravelTime(adjacencyMatrix,14, 15, 4);  // Нарвская <-> Кировский завод
        setTravelTime(adjacencyMatrix,15, 16, 2);  // Кировский завод <-> Автово
        setTravelTime(adjacencyMatrix,16, 17, 3);  // Автово <-> Ленинский проспект
        setTravelTime(adjacencyMatrix,17, 18, 2);  // Ленинский проспект <-> Проспект ветеранов

        // Линия 2
        setTravelTime(adjacencyMatrix,19, 20, 3);  // Парнас <-> Проспект Просвещения
        setTravelTime(adjacencyMatrix,20, 21, 2);  // Проспект Просвещения <-> Озерки
        setTravelTime(adjacencyMatrix,21, 22, 3);  // Озерки <-> Удельная
        setTravelTime(adjacencyMatrix,22, 23, 3);  // Удельная <-> Пионерская
        setTravelTime(adjacencyMatrix,23, 24, 3);  // Пионерская <-> Черная Речка
        setTravelTime(adjacencyMatrix,24, 25, 4);  // Черная Речка <-> Петроградская
        setTravelTime(adjacencyMatrix,25, 26, 2);  // Петроградская <-> Горьковская
        setTravelTime(adjacencyMatrix,26, 27, 4);  // Горьковская <-> Невский проспект
        setTravelTime(adjacencyMatrix,27, 28, 2);  // Невский проспект <-> Сенная площадь
        setTravelTime(adjacencyMatrix,28, 29, 4);  // Сенная площадь <-> Технологический институт 2
        setTravelTime(adjacencyMatrix,29, 30, 3);  // Технологический институт 2 <-> Фрунзенская
        setTravelTime(adjacencyMatrix,30, 31, 2);  // Фрунзенская <-> Московские ворота
        setTravelTime(adjacencyMatrix,31, 32, 2);  // Московские ворота <-> Электросила
        setTravelTime(adjacencyMatrix,32, 33, 2);  // Электросила <-> Парк Победы
        setTravelTime(adjacencyMatrix,33, 34, 3);  // Парк Победы <-> Московская
        setTravelTime(adjacencyMatrix,34, 35, 4);  // Московская <-> Звездная
        setTravelTime(adjacencyMatrix,35, 36, 3);  // Звездная <-> Купчино

        // Линия 3
        setTravelTime(adjacencyMatrix,37, 38, 4);  // Беговая <-> Зенит
        setTravelTime(adjacencyMatrix,38, 39, 4);  // Зенит <-> Приморская
        setTravelTime(adjacencyMatrix,39, 40, 4);  // Приморская <-> Василеостровская
        setTravelTime(adjacencyMatrix,40, 41, 5);  // Василеостровская <-> Гостиный двор
        setTravelTime(adjacencyMatrix,41, 42, 5);  // Гостиный двор <-> Маяковская
        setTravelTime(adjacencyMatrix,42, 43, 5);  // Маяковская <-> Площадь Александра Невского 1
        setTravelTime(adjacencyMatrix,43, 44, 6);  // Площадь Александра Невского 1 <-> Елизаровская
        setTravelTime(adjacencyMatrix,44, 45, 3);  // Елизаровская <-> Ломоносовская
        setTravelTime(adjacencyMatrix,45, 46, 3);  // Ломоносовская <-> Пролетарская
        setTravelTime(adjacencyMatrix,46, 47, 3);  // Пролетарская <-> Обухово
        setTravelTime(adjacencyMatrix,47, 48, 4);  // Обухово <-> Рыбацкое

        // Линия 4
        setTravelTime(adjacencyMatrix,49, 50, 2);  // Улица Дыбенко <-> Проспект Большевиков
        setTravelTime(adjacencyMatrix,50, 51, 3);  // Проспект Большевиков <-> Ладожская
        setTravelTime(adjacencyMatrix,51, 52, 3);  // Ладожская <-> Новочеркасская
        setTravelTime(adjacencyMatrix,52, 53, 3);  // Новочеркасская <-> Площадь Александра Невского 2
        setTravelTime(adjacencyMatrix,53, 54, 2);  // Площадь Александра Невского 2 <-> Лиговский проспект
        setTravelTime(adjacencyMatrix,54, 55, 4);  // Лиговский проспект <-> Достоевская
        setTravelTime(adjacencyMatrix,55, 56, 5);  // Достоевская <-> Спасская

        // Линия 5
        setTravelTime(adjacencyMatrix,57, 58, 3);  // Комендантский проспект <-> Старая Деревня
        setTravelTime(adjacencyMatrix,58, 59, 3);  // Старая Деревня <-> Крестовский остров
        setTravelTime(adjacencyMatrix,59, 60, 4);  // Крестовский остров <-> Чкаловская
        setTravelTime(adjacencyMatrix,60, 61, 2);  // Чкаловская <-> Спортивная
        setTravelTime(adjacencyMatrix,61, 62, 3);  // Спортивная <-> Адмиралтейская
        setTravelTime(adjacencyMatrix,62, 63, 4);  // Адмиралтейская <-> Садовая
        setTravelTime(adjacencyMatrix,63, 64, 6);  // Садовая <-> Звенигородская
        setTravelTime(adjacencyMatrix,64, 65, 4);  // Звенигородская <-> Обводный канал
        setTravelTime(adjacencyMatrix,65, 66, 3);  // Обводный канал <-> Волковская
        setTravelTime(adjacencyMatrix,66, 67, 3);  // Волковская <-> Бухарестская
        setTravelTime(adjacencyMatrix,67, 68, 3);  // Бухарестская <-> Международная
        setTravelTime(adjacencyMatrix,68, 69, 2);  // Международная <-> Проспект славы
        setTravelTime(adjacencyMatrix,69, 70, 3);  // Проспект славы <-> Дунайская
        setTravelTime(adjacencyMatrix,70, 71, 4);  // Дунайская <-> Шушары

        // Пересадки
        setTravelTime(adjacencyMatrix,12, 29, 2);  // Технологический институт 1 <-> Технологический институт 2
        setTravelTime(adjacencyMatrix,43, 53, 2);  // Площадь Александра Невского 1 <-> Площадь Александра Невского 2
        setTravelTime(adjacencyMatrix,11, 64, 2);  // Пушкинская <-> Звенигородская
        setTravelTime(adjacencyMatrix,55, 10, 2);  // Достоевская <-> Владимирская
        setTravelTime(adjacencyMatrix,27, 41, 2);  // Невский проспект <-> Гостиный двор
        setTravelTime(adjacencyMatrix,9, 42, 2);  // Площадь восстания <-> Маяковская
        setTravelTime(adjacencyMatrix,28, 63 ,2); // Сенная площадь <-> Садовая
        setTravelTime(adjacencyMatrix,56, 63 ,2); // Спасская <-> Садовая
        setTravelTime(adjacencyMatrix,28, 56 ,2); // Сенная площадь <-> Спасская

        // Используем Scanner для ввода названий станций
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем станцию 1
        logger.info("Запрос первой станции у пользователя.");
        System.out.println("Введите название первой станции: ");
        String station1Name = scanner.nextLine();
        int station1Index = getStationIndex(station1Name);

        // Запрашиваем станцию 2
        logger.info("Запрос второй станции у пользователя.");
        System.out.println("Введите название второй станции: ");
        String station2Name = scanner.nextLine();
        int station2Index = getStationIndex(station2Name);

        // Проверка индексов станций
        if (station1Index == -1 || station2Index == -1) {
            logger.warning("Одна из введенных станций не найдена.");
            System.out.println("Одна или обе станции не найдены.");
            return;
        }

        // Получаем время путешествия между выбранными станциями
        logger.info("Вычисление минимального времени между станциями.");
        int travelTime = Dijkstra.getShortestPath(adjacencyMatrix, station1Index, station2Index);

        // Логируем результат
        if (travelTime != Integer.MAX_VALUE) {
            logger.info("Минимальное время путешествия: " + travelTime + " минут.");
            System.out.println("Минимальное время путешествия между станциями '" + station1Name + "' и '" + station2Name + "' : " + travelTime + " минут.");
        } else {
            logger.warning("Нет пути между станциями.");
            System.out.println("Нет пути между станциями.");
        }

        scanner.close();
    }

    /**
     * Устанавливает время путешествия между двумя станциями.
     *
     * @param matrix Матрица смежности, которая хранит данные о времени между станциями.
     * @param station1 Индекс первой станции.
     * @param station2 Индекс второй станции.
     * @param time Время путешествия между станциями.
     */

    // Метод для установки времени путешествия между станциями
    private static void setTravelTime(int[][] matrix, int station1, int station2, int time) {
        matrix[station1][station2] = time;
        matrix[station2][station1] = time;  // Так как это неориентированный граф
    }

    // Метод для поиска индекса станции по названию
    private static int getStationIndex(String stationName) {
        for (int i = 0; i < stationNames.length; i++) {
            if (stationNames[i].equalsIgnoreCase(stationName)) {
                return i;
            }
        }
        return -1;  // Возвращаем -1, если станция не найдена
    }
}
