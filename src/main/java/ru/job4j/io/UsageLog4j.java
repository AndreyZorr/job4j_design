package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 5;
        byte name = 10;
        short size = 93;
        long length = 1;
        float number = 15.68F;
        double lg = 19.04;
        boolean bo = false;
        char ch = '$';
        LOG.debug("int:{}; byte:{}; short:{}; long:{}; float:{}; double:{}; boolean:{}; char:{};",
                age, name, size, length, number, lg, bo, ch);
    }
}
