package com.example.metro;

/**
 * ����� ��� ������������� ����� ����� � �������������� ������� ���������.
 * ������ ���������� � ������� ����������� ����� ���������.
 */

public class Graph {
    private int[][] adjacencyMatrix;

    /**
     * ����������� ��� �������� ����� ����� � �������� ����������� �������.
     * �������������� ������� ��������� ��� ��������� ����� �������.
     *
     * @param numStations ���������� ������� � �����.
     */

    public Graph(int numStations) {
        adjacencyMatrix = new int[numStations][numStations];
    }

    /**
     * ������������� ����� ����������� ����� ����� ���������.
     * ��������� ������� ��������� ��������� ������� ��� ����� ������� (����������������� ����).
     *
     * @param station1 ������ ������ �������.
     * @param station2 ������ ������ �������.
     * @param time ����� ����������� ����� ���������.
     */

    // ����� ��� ��������� ������� ����������� ����� ���������
    public void setTravelTime(int station1, int station2, int time) {
        adjacencyMatrix[station1][station2] = time;
        adjacencyMatrix[station2][station1] = time;  // ��� ������������������ �����
    }

    /**
     * �������� ������� ��������� ��� �����.
     *
     * @return ������� ���������, ��� �������� � ������ [i][j] ������������ ����� �����������
     *         ����� ��������� i � j.
     */

    // ����� ��� ��������� ������� ���������
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
