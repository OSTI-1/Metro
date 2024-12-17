package com.example.metro;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void testMainWithValidInput() {
        // ���������� ����� (��������� ���� ������������: ��������� � �������� �������)
        String input = "0\n5\n"; // ������������ ������ 0 � 5 (������� �����)
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // ������������� ����� � �������
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // ��������� ����� main
        App.main(new String[]{});

        // ���������, ��� ����� �������� ��������� ������
        String output = outContent.toString();
        assertTrue(output.contains("Shortest path"), "Output should contain 'Shortest path'");
        assertTrue(output.contains("Total travel time"), "Output should contain 'Total travel time'");

        // ���������� ����������� ������
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainWithInvalidInput() {
        // ���������� ����� (�������� �������)
        String input = "72\n-1\n"; // ������������ ������ ������������ ������ �������
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // ������������� ����� � �������
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // ��������� ����� main
        App.main(new String[]{});

        // ���������, ��� ����� �������� ��������� �� ������
        String output = outContent.toString();
        assertTrue(output.contains("Invalid station number"), "Output should contain 'Invalid station number'");

        // ���������� ����������� ������
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
