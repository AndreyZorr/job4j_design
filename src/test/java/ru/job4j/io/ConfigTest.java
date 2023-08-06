package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair without comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenAddit() {
        String path = "./data/addit.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Andrey=");
    }
    @Test
    void whenEmpty() {
        String path = "./data/empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("age")).isEqualTo("32");
    }
    @Test
    void whenBrokenTemp() {
        String path = "./data/brokentemp.properties";
        Config config = new Config(path);
       IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
               config::load
       );
       assertThat(exception.getMessage()).isEqualTo("=");
    }
}
