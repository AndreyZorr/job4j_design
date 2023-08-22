package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j");

        String text1 = "JOB4j";
        Matcher matcher1 = pattern.matcher(text1);
        boolean isPresent1 = matcher1.matches();
        System.out.println(isPresent1);

        String text2 = "Job4j и Job4j и Job4j";
        Matcher matcher2 = pattern.matcher(text2);
        while (matcher2.find()) {
            System.out.println("Найдено совпадение !");
        }

        String text = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }

        String text3 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher3 = pattern.matcher(text3);
        while (matcher3.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher3.start()
                    + " iEnd: " + matcher3.end());
        }

        Pattern pattern4 = Pattern.compile("123");
        String text4 = "1231 и 1232 и 1233";
        Matcher matcher4 = pattern4.matcher(text4);
        String rsl = matcher4.replaceAll("ТАран");
        System.out.println(rsl);
    }
}
