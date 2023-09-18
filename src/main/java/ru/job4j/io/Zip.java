package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zipOS = new ZipOutputStream((new BufferedOutputStream(new FileOutputStream(target))))) {
            for (Path source : sources) {
                File file = source.toFile();
                zipOS.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zipOS.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validate(ArgsName args) {
        File file = new File(args.get("d"));
        if (!Files.isDirectory(file.toPath())) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.toPath()));
        }
        if (!args.get("e").startsWith(".")) {
            throw new IllegalArgumentException("The argument should starts with.");
        }
        if (!args.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The argument should ends with .zip");
        }
    }

    public static void main(String[] args) throws IOException {
       if (args.length != 3) {
           throw new IllegalArgumentException("");
       }
       ArgsName argsName = ArgsName.of(args);
       validate(argsName);
        Predicate<Path> condition = path -> !path.toFile().getName().endsWith(argsName.get("e"));
        try {
            List<Path> paths = Search.search(Paths.get(argsName.get("d")), condition);
            new Zip().packFiles(paths, new File(argsName.get("o")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 **/