package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
            FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
            map.putIfAbsent(fileProperty, new ArrayList<>());
            map.get(fileProperty).add(file);
        return super.visitFile(file, attrs);
    }
    public Map<FileProperty, List<Path>> getDuplicates() {
        return map;
    }
}
