package com.example.metro;

/**
 * Класс для представления графа метро с использованием матрицы смежности.
 * Хранит информацию о времени путешествия между станциями.
 */

public class Graph {
    private int[][] adjacencyMatrix;

    /**
     * Конструктор для создания графа метро с заданным количеством станций.
     * Инициализирует матрицу смежности для заданного числа станций.
     *
     * @param numStations Количество станций в графе.
     */

    public Graph(int numStations) {
        adjacencyMatrix = new int[numStations][numStations];
    }

    /**
     * Устанавливает время путешествия между двумя станциями.
     * Заполняет матрицу смежности значением времени для обеих станций (неориентированный граф).
     *
     * @param station1 Индекс первой станции.
     * @param station2 Индекс второй станции.
     * @param time Время путешествия между станциями.
     */

    // Метод для установки времени путешествия между станциями
    public void setTravelTime(int station1, int station2, int time) {
        adjacencyMatrix[station1][station2] = time;
        adjacencyMatrix[station2][station1] = time;  // Для неориентированного графа
    }

    /**
     * Получает матрицу смежности для графа.
     *
     * @return Матрица смежности, где значение в ячейке [i][j] представляет время путешествия
     *         между станциями i и j.
     */

    // Метод для получения матрицы смежности
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
