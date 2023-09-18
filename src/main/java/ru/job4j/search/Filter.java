package ru.job4j.search;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    private String fileMask;

    public Filter(String fileMask) {
        this.fileMask = fileMask;
    }

    @Override
    public boolean accept(File directory, String fileName) {
        return (fileName.matches(this.fileMask));
    }
}
