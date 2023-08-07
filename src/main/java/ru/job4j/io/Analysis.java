package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(
                    new FileOutputStream(target, true)))) {
                String st = null;
                String line;
                while ((line = br.readLine()) != null) {
                    boolean working = line.startsWith("200") || line.startsWith("300");
                    if (!working && st == null) {
                        st = line.substring(3);
                    } else if (st != null && working) {
                        pw.printf("%s;%s%n", st, line.substring(3));
                        st = null;
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
