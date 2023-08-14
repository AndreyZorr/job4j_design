package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException(String.format("Invalid number of arguments- %s. "
                    + "Expected quantity  - 2", args.length));
        }
        validate(args);
        String startsWith = args[1];
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(startsWith)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validate(String[] args) throws IllegalArgumentException {
        String start = args[0];
        String startsWith = args[1];
        if (!Files.isDirectory(Path.of(start))) {
            throw new IllegalArgumentException(String.format("Not a directory %s", start));
        }
        if (startsWith.startsWith(".") || startsWith.length() < 2) {
            throw new IllegalArgumentException(String.format("Illegal file extension- %s", startsWith));
        }
    }
}
