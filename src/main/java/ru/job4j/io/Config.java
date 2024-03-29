package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }
    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#") && !line.isEmpty() && !(line.matches(".+=.+"))) {
                    throw new IllegalArgumentException(line);
                }
                if (line.matches(".+=.+")) {
                    int i = line.indexOf('=');
                    values.put(line.substring(0, i), line.substring(i + 1));
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public String value(String key) {
        return values.get(key);
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Config("C:\\projects\\job4j_design\\app.properties"));
    }
}