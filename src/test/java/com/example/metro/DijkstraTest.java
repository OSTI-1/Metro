package com.example.metro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {

    @Test
    void testFindShortestPath() {
        // Подготовка графа: эмулируем наличие времени между станциями
        int[][] adjacencyMatrix = {
                {0, 5, 0, 0, 0},
                {5, 0, 10, 0, 0},
                {0, 10, 0, 15, 0},
                {0, 0, 15, 0, 20},
                {0, 0, 0, 20, 0}
        };

        // Инициализация класса Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Получаем минимальные расстояния из станции 0
        int[] distances = dijkstra.findShortestPath(adjacencyMatrix, 0);

        // Проверяем, что минимальное расстояние до станции 2 равно 15 (путь 0 -> 1 -> 2)
        assertEquals(15, distances[2], "Shortest path from station 0 to station 2 should be 15");

        // Проверяем, что минимальное расстояние до станции 3 равно 20 (путь 0 -> 1 -> 3)
        assertEquals(20, distances[3], "Shortest path from station 0 to station 3 should be 20");

        // Проверяем, что минимальное расстояние до станции 4 равно 25 (путь 0 -> 1 -> 3 -> 4)
        assertEquals(25, distances[4], "Shortest path from station 0 to station 4 should be 25");
    }
}
