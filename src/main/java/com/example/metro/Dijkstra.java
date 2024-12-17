package com.example.metro;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * ����� ��� ���������� ��������� �������� ��� ������ ����������� ���� ����� ��������� �����.
 * �������� ������ ��� ���������� ����������� ���������� � ��������� ����������� ����.
 */

public class Dijkstra {

    // ������ ��� ����������� ���������
    private static final Logger logger = Logger.getLogger(Dijkstra.class.getName());

    /**
     * ������� ���������� ���� �� �������� ��������� ������� �� ���� ��������� ��������.
     *
     * @param adjacencyMatrix ������� ���������, ������� ������ ������ � ������� ����������� ����� ���������.
     * @param startStation ������ ��������� �������.
     * @return ������ ����������� ���������� �� ��������� ������� �� ���� ���������.
     */

    // ����� ��� ���������� ����������� ���� � �������������� ��������� ��������
    public static int[] findShortestPath(int[][] adjacencyMatrix, int startStation) {
        int n = adjacencyMatrix.length;
        int[] distances = new int[n];  // ������ ��� �������� ����������� ����������
        boolean[] visited = new boolean[n];  // ������ ��� ������������ ���������� �������

        // �������������: ���������� �� ���� ������� - �������������, ����� ���������
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startStation] = 0;

        logger.info("������ ������� ���������� ����� �� ������� " + startStation);

        for (int i = 0; i < n; i++) {
            // ����� ������� � ����������� �����������
            int u = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    u = j;
                    minDistance = distances[j];
                }
            }

            if (u == -1) {
                logger.info("��� ������� ��������, ���������� ���������.");
                break;  // ���� ��� ������� ��������, �������
            }

            // �������� ��������� ������� ��� ����������
            visited[u] = true;
            logger.fine("�������� �������: " + u);

            // ���������� ����������� ����������
            for (int v = 0; v < n; v++) {
                if (adjacencyMatrix[u][v] != 0 && !visited[v]) {  // ���� ���� ����������
                    int newDist = distances[u] + adjacencyMatrix[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                        logger.fine("��������� ���������� �� ������� " + v + ": " + distances[v]);
                    }
                }
            }
        }

        return distances;  // ���������� ������ ����������� ���������� �� startStation
    }

    /**
     * ������� ���������� ���� �� ����� ������� �� ������.
     *
     * @param adjacencyMatrix ������� ���������, ������� ������ ������ � ������� ����������� ����� ���������.
     * @param startStation ������ ��������� �������.
     * @param endStation ������ �������� �������.
     * @return ����������� ���������� (�����) ����� ��������� � �������� ��������.
     */

    // ����� ��� ��������� ����������� ���� ����� ����� ���������
    public static int getShortestPath(int[][] adjacencyMatrix, int startStation, int endStation) {
        logger.info("������ �� ���������� ���� �� ������� " + startStation + " �� ������� " + endStation);
        int[] distances = findShortestPath(adjacencyMatrix, startStation);
        int shortestPath = distances[endStation];
        logger.info("����������� ����� ����: " + shortestPath + " �����.");
        return shortestPath;  // ���������� ����������� ���������� �� �������� �������
    }
}
