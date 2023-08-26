package ru.job4j.regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private String getPhrasese(List<String> phrases) {
        return phrases.get((int) (phrases.size() * Math.random()));
    }

    public void run() {
        boolean rsl = true;
        List<String> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Здраствуйте !");
        String name = input.nextLine();
        List<String> readPhrases = readPhrases();
        String answer = getPhrasese(readPhrases);
        while (!OUT.equals(name)) {
            list.add(name);
            if (STOP.equals(name)) {
                rsl = false;
            } else if (CONTINUE.equals(name)) {
                rsl = true;
            } else if (rsl) {
                System.out.println(answer);
                list.add(answer);
            }
            name = input.nextLine();
        }
        list.add(name);
        saveLog(list);
    }

    private List<String> readPhrases() {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(botAnswers))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {
            for (String line : log) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/path.txt",
                "data/botAnswers.txt");
        cc.run();
    }
}