package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/multiple.txt")) {
            for (int i = 1; i <= 1; i++) {
                for (int j = 1; j <= 10; j++) {
                    String line = i + "*" + j + "=" + i * j;
                    out.write(line.getBytes());
                    out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
