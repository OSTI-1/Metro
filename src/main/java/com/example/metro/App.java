package com.example.metro;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ������� ����� ���������� ��� ������� ������������ ������� ���� ����� ��������� �����.
 * �������� ������ ��� ��������� ������� ����������� ����� ���������,
 * ������ ������� ������� �� �������� � �������������� � �������������.
 */

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());  // ������������� �������
    private static final String[] stationNames = {
            "���������", "����������� ��������", "�������������", "���������������",
            "������� ��������", "������", "����������", "������� ������", "������������",
            "������� ���������", "������������", "����������", "��������������� �������� 1",
            "����������", "��������", "��������� �����", "������", "��������� ��������",
            "�������� ���������", "������", "�������� �����������", "������", "��������",
            "����������", "������ �����", "�������������", "�����������", "������� ��������",
            "������ �������", "��������������� �������� 2", "�����������", "���������� ������",
            "�����������", "���� ������", "����������", "��������", "�������", "�������",
            "�����", "����������", "����������������", "�������� ����", "����������",
            "������� ���������� �������� 1", "������������", "�������������", "������������",
            "�������", "��������", "����� �������", "�������� �����������", "���������",
            "��������������", "������� ���������� �������� 2", "��������� ��������", "�����������",
            "��������", "������������� ��������", "������ �������", "����������� ������",
            "����������", "����������", "��������������", "�������", "��������������",
            "�������� �����", "����������", "������������", "�������������", "�������� �����",
            "���������", "������"
    };

    /**
     * �������� ����� ����������, ������� ��������� �������������� � �������������,
     * ����������� ������� � ������� ����������� ����� ����������� ����� ����.
     *
     * @param args ��������� ��������� ������ (�� ������������).
     */

    public static void main(String[] args) {
        int numStations = stationNames.length;

        // �������� ������� ���������
        int[][] adjacencyMatrix = new int[numStations][numStations];

        // ����� 1
        setTravelTime(adjacencyMatrix,0, 1, 3);  // ��������� <-> ����������� ��������
        setTravelTime(adjacencyMatrix,1, 2, 6);  // ����������� �������� <-> �������������
        setTravelTime(adjacencyMatrix,2, 3, 2);  // ������������� <-> ���������������
        setTravelTime(adjacencyMatrix,3, 4, 3);  // ��������������� <-> ������� ��������
        setTravelTime(adjacencyMatrix,4, 5, 3);  // ������� �������� <-> ������
        setTravelTime(adjacencyMatrix,5, 6, 3);  // ������ <-> ����������
        setTravelTime(adjacencyMatrix,6, 7, 2);  // ���������� <-> ������� ������
        setTravelTime(adjacencyMatrix,7, 8, 3);  // ������� ������ <-> ������������
        setTravelTime(adjacencyMatrix,8, 9, 2);  // ������������ <-> ������� ���������
        setTravelTime(adjacencyMatrix,9, 10, 2);  // ������� ��������� <-> ������������
        setTravelTime(adjacencyMatrix,10, 11, 2);  // ������������ <-> ����������
        setTravelTime(adjacencyMatrix,11, 12, 3);  // ���������� <-> ��������������� �������� 1
        setTravelTime(adjacencyMatrix,12, 13, 3);  // ��������������� �������� 1 <-> ����������
        setTravelTime(adjacencyMatrix,13, 14, 3);  // ���������� <-> ��������
        setTravelTime(adjacencyMatrix,14, 15, 4);  // �������� <-> ��������� �����
        setTravelTime(adjacencyMatrix,15, 16, 2);  // ��������� ����� <-> ������
        setTravelTime(adjacencyMatrix,16, 17, 3);  // ������ <-> ��������� ��������
        setTravelTime(adjacencyMatrix,17, 18, 2);  // ��������� �������� <-> �������� ���������

        // ����� 2
        setTravelTime(adjacencyMatrix,19, 20, 3);  // ������ <-> �������� �����������
        setTravelTime(adjacencyMatrix,20, 21, 2);  // �������� ����������� <-> ������
        setTravelTime(adjacencyMatrix,21, 22, 3);  // ������ <-> ��������
        setTravelTime(adjacencyMatrix,22, 23, 3);  // �������� <-> ����������
        setTravelTime(adjacencyMatrix,23, 24, 3);  // ���������� <-> ������ �����
        setTravelTime(adjacencyMatrix,24, 25, 4);  // ������ ����� <-> �������������
        setTravelTime(adjacencyMatrix,25, 26, 2);  // ������������� <-> �����������
        setTravelTime(adjacencyMatrix,26, 27, 4);  // ����������� <-> ������� ��������
        setTravelTime(adjacencyMatrix,27, 28, 2);  // ������� �������� <-> ������ �������
        setTravelTime(adjacencyMatrix,28, 29, 4);  // ������ ������� <-> ��������������� �������� 2
        setTravelTime(adjacencyMatrix,29, 30, 3);  // ��������������� �������� 2 <-> �����������
        setTravelTime(adjacencyMatrix,30, 31, 2);  // ����������� <-> ���������� ������
        setTravelTime(adjacencyMatrix,31, 32, 2);  // ���������� ������ <-> �����������
        setTravelTime(adjacencyMatrix,32, 33, 2);  // ����������� <-> ���� ������
        setTravelTime(adjacencyMatrix,33, 34, 3);  // ���� ������ <-> ����������
        setTravelTime(adjacencyMatrix,34, 35, 4);  // ���������� <-> ��������
        setTravelTime(adjacencyMatrix,35, 36, 3);  // �������� <-> �������

        // ����� 3
        setTravelTime(adjacencyMatrix,37, 38, 4);  // ������� <-> �����
        setTravelTime(adjacencyMatrix,38, 39, 4);  // ����� <-> ����������
        setTravelTime(adjacencyMatrix,39, 40, 4);  // ���������� <-> ����������������
        setTravelTime(adjacencyMatrix,40, 41, 5);  // ���������������� <-> �������� ����
        setTravelTime(adjacencyMatrix,41, 42, 5);  // �������� ���� <-> ����������
        setTravelTime(adjacencyMatrix,42, 43, 5);  // ���������� <-> ������� ���������� �������� 1
        setTravelTime(adjacencyMatrix,43, 44, 6);  // ������� ���������� �������� 1 <-> ������������
        setTravelTime(adjacencyMatrix,44, 45, 3);  // ������������ <-> �������������
        setTravelTime(adjacencyMatrix,45, 46, 3);  // ������������� <-> ������������
        setTravelTime(adjacencyMatrix,46, 47, 3);  // ������������ <-> �������
        setTravelTime(adjacencyMatrix,47, 48, 4);  // ������� <-> ��������

        // ����� 4
        setTravelTime(adjacencyMatrix,49, 50, 2);  // ����� ������� <-> �������� �����������
        setTravelTime(adjacencyMatrix,50, 51, 3);  // �������� ����������� <-> ���������
        setTravelTime(adjacencyMatrix,51, 52, 3);  // ��������� <-> ��������������
        setTravelTime(adjacencyMatrix,52, 53, 3);  // �������������� <-> ������� ���������� �������� 2
        setTravelTime(adjacencyMatrix,53, 54, 2);  // ������� ���������� �������� 2 <-> ��������� ��������
        setTravelTime(adjacencyMatrix,54, 55, 4);  // ��������� �������� <-> �����������
        setTravelTime(adjacencyMatrix,55, 56, 5);  // ����������� <-> ��������

        // ����� 5
        setTravelTime(adjacencyMatrix,57, 58, 3);  // ������������� �������� <-> ������ �������
        setTravelTime(adjacencyMatrix,58, 59, 3);  // ������ ������� <-> ����������� ������
        setTravelTime(adjacencyMatrix,59, 60, 4);  // ����������� ������ <-> ����������
        setTravelTime(adjacencyMatrix,60, 61, 2);  // ���������� <-> ����������
        setTravelTime(adjacencyMatrix,61, 62, 3);  // ���������� <-> ��������������
        setTravelTime(adjacencyMatrix,62, 63, 4);  // �������������� <-> �������
        setTravelTime(adjacencyMatrix,63, 64, 6);  // ������� <-> ��������������
        setTravelTime(adjacencyMatrix,64, 65, 4);  // �������������� <-> �������� �����
        setTravelTime(adjacencyMatrix,65, 66, 3);  // �������� ����� <-> ����������
        setTravelTime(adjacencyMatrix,66, 67, 3);  // ���������� <-> ������������
        setTravelTime(adjacencyMatrix,67, 68, 3);  // ������������ <-> �������������
        setTravelTime(adjacencyMatrix,68, 69, 2);  // ������������� <-> �������� �����
        setTravelTime(adjacencyMatrix,69, 70, 3);  // �������� ����� <-> ���������
        setTravelTime(adjacencyMatrix,70, 71, 4);  // ��������� <-> ������

        // ���������
        setTravelTime(adjacencyMatrix,12, 29, 2);  // ��������������� �������� 1 <-> ��������������� �������� 2
        setTravelTime(adjacencyMatrix,43, 53, 2);  // ������� ���������� �������� 1 <-> ������� ���������� �������� 2
        setTravelTime(adjacencyMatrix,11, 64, 2);  // ���������� <-> ��������������
        setTravelTime(adjacencyMatrix,55, 10, 2);  // ����������� <-> ������������
        setTravelTime(adjacencyMatrix,27, 41, 2);  // ������� �������� <-> �������� ����
        setTravelTime(adjacencyMatrix,9, 42, 2);  // ������� ��������� <-> ����������
        setTravelTime(adjacencyMatrix,28, 63 ,2); // ������ ������� <-> �������
        setTravelTime(adjacencyMatrix,56, 63 ,2); // �������� <-> �������
        setTravelTime(adjacencyMatrix,28, 56 ,2); // ������ ������� <-> ��������

        // ���������� Scanner ��� ����� �������� �������
        Scanner scanner = new Scanner(System.in);

        // ����������� ������� 1
        logger.info("������ ������ ������� � ������������.");
        System.out.println("������� �������� ������ �������: ");
        String station1Name = scanner.nextLine();
        int station1Index = getStationIndex(station1Name);

        // ����������� ������� 2
        logger.info("������ ������ ������� � ������������.");
        System.out.println("������� �������� ������ �������: ");
        String station2Name = scanner.nextLine();
        int station2Index = getStationIndex(station2Name);

        // �������� �������� �������
        if (station1Index == -1 || station2Index == -1) {
            logger.warning("���� �� ��������� ������� �� �������.");
            System.out.println("���� ��� ��� ������� �� �������.");
            return;
        }

        // �������� ����� ����������� ����� ���������� ���������
        logger.info("���������� ������������ ������� ����� ���������.");
        int travelTime = Dijkstra.getShortestPath(adjacencyMatrix, station1Index, station2Index);

        // �������� ���������
        if (travelTime != Integer.MAX_VALUE) {
            logger.info("����������� ����� �����������: " + travelTime + " �����.");
            System.out.println("����������� ����� ����������� ����� ��������� '" + station1Name + "' � '" + station2Name + "' : " + travelTime + " �����.");
        } else {
            logger.warning("��� ���� ����� ���������.");
            System.out.println("��� ���� ����� ���������.");
        }

        scanner.close();
    }

    /**
     * ������������� ����� ����������� ����� ����� ���������.
     *
     * @param matrix ������� ���������, ������� ������ ������ � ������� ����� ���������.
     * @param station1 ������ ������ �������.
     * @param station2 ������ ������ �������.
     * @param time ����� ����������� ����� ���������.
     */

    // ����� ��� ��������� ������� ����������� ����� ���������
    private static void setTravelTime(int[][] matrix, int station1, int station2, int time) {
        matrix[station1][station2] = time;
        matrix[station2][station1] = time;  // ��� ��� ��� ����������������� ����
    }

    // ����� ��� ������ ������� ������� �� ��������
    private static int getStationIndex(String stationName) {
        for (int i = 0; i < stationNames.length; i++) {
            if (stationNames[i].equalsIgnoreCase(stationName)) {
                return i;
            }
        }
        return -1;  // ���������� -1, ���� ������� �� �������
    }
}
