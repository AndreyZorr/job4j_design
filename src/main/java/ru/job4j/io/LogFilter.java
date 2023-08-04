package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if ("404".equals(parts[parts.length - 2])) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String line : data) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

        public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        new LogFilter("data/log.txt").saveTo("data/out.txt");
        logFilter.filter().forEach(System.out::println);

    }
}