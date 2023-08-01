package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                array[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[][] multiple = multiple(9);
        try (FileOutputStream out = new FileOutputStream("data/multiple.txt")) {
            for (int[] row : multiple) {
                String line = Arrays.toString(row);
                out.write(line.substring(1, line.length() - 1).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
