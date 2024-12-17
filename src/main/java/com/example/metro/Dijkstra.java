package com.example.metro;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Класс для реализации алгоритма Дейкстры для поиска кратчайшего пути между станциями метро.
 * Содержит методы для нахождения минимальных расстояний и получения кратчайшего пути.
 */

public class Dijkstra {

    // Логгер для логирования сообщений
    private static final Logger logger = Logger.getLogger(Dijkstra.class.getName());

    /**
     * Находит кратчайшие пути от заданной начальной станции ко всем остальным станциям.
     *
     * @param adjacencyMatrix Матрица смежности, которая хранит данные о времени путешествия между станциями.
     * @param startStation Индекс начальной станции.
     * @return Массив минимальных расстояний от начальной станции ко всем остальным.
     */

    // Метод для нахождения кратчайшего пути с использованием алгоритма Дейкстры
    public static int[] findShortestPath(int[][] adjacencyMatrix, int startStation) {
        int n = adjacencyMatrix.length;
        int[] distances = new int[n];  // Массив для хранения минимальных расстояний
        boolean[] visited = new boolean[n];  // Массив для отслеживания посещенных станций

        // Инициализация: расстояние до всех станций - бесконечность, кроме начальной
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startStation] = 0;

        logger.info("Начало расчета кратчайших путей от станции " + startStation);

        for (int i = 0; i < n; i++) {
            // Выбор станции с минимальным расстоянием
            int u = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    u = j;
                    minDistance = distances[j];
                }
            }

            if (u == -1) {
                logger.info("Все станции посещены, завершение алгоритма.");
                break;  // Если все станции посещены, выходим
            }

            // Отмечаем выбранную станцию как посещенную
            visited[u] = true;
            logger.fine("Посещена станция: " + u);

            // Обновление минимальных расстояний
            for (int v = 0; v < n; v++) {
                if (adjacencyMatrix[u][v] != 0 && !visited[v]) {  // Если есть соединение
                    int newDist = distances[u] + adjacencyMatrix[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                        logger.fine("Обновлено расстояние до станции " + v + ": " + distances[v]);
                    }
                }
            }
        }

        return distances;  // Возвращаем массив минимальных расстояний от startStation
    }

    /**
     * Находит кратчайший путь от одной станции до другой.
     *
     * @param adjacencyMatrix Матрица смежности, которая хранит данные о времени путешествия между станциями.
     * @param startStation Индекс начальной станции.
     * @param endStation Индекс конечной станции.
     * @return Минимальное расстояние (время) между начальной и конечной станцией.
     */

    // Метод для получения кратчайшего пути между двумя станциями
    public static int getShortestPath(int[][] adjacencyMatrix, int startStation, int endStation) {
        logger.info("Запрос на кратчайший путь от станции " + startStation + " до станции " + endStation);
        int[] distances = findShortestPath(adjacencyMatrix, startStation);
        int shortestPath = distances[endStation];
        logger.info("Минимальное время пути: " + shortestPath + " минут.");
        return shortestPath;  // Возвращаем минимальное расстояние до конечной станции
    }
}
