package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {

    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("server.log").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "500 10:59:01\n"
                    + "400 11:01:02\n"
                    + "300 11:02:02");
        }
        File target = tempDir.resolve("target.csv").toFile();
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("server.log", "target.csv"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl).hasToString(rsl.toString());
    }
}
