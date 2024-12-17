package com.example.metro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {

    @Test
    void testFindShortestPath() {
        // ���������� �����: ��������� ������� ������� ����� ���������
        int[][] adjacencyMatrix = {
                {0, 5, 0, 0, 0},
                {5, 0, 10, 0, 0},
                {0, 10, 0, 15, 0},
                {0, 0, 15, 0, 20},
                {0, 0, 0, 20, 0}
        };

        // ������������� ������ Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // �������� ����������� ���������� �� ������� 0
        int[] distances = dijkstra.findShortestPath(adjacencyMatrix, 0);

        // ���������, ��� ����������� ���������� �� ������� 2 ����� 15 (���� 0 -> 1 -> 2)
        assertEquals(15, distances[2], "Shortest path from station 0 to station 2 should be 15");

        // ���������, ��� ����������� ���������� �� ������� 3 ����� 20 (���� 0 -> 1 -> 3)
        assertEquals(20, distances[3], "Shortest path from station 0 to station 3 should be 20");

        // ���������, ��� ����������� ���������� �� ������� 4 ����� 25 (���� 0 -> 1 -> 3 -> 4)
        assertEquals(25, distances[4], "Shortest path from station 0 to station 4 should be 25");
    }
}
