package ru.job4j.io;

import java.io.*;

public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"));
             PrintStream write = new PrintStream("data/write.txt")) {
            stream.println("Из PrintStream в FileOutputStream");
            stream.write("Новая строка".getBytes());
            write.println("Новое сообщение");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}