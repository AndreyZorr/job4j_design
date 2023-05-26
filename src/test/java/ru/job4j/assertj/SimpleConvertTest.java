package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array)
                .hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(array)
                .isNotNull()
                .contains("second", "five")
                .containsOnly("second", "three", "four", "first", "five")
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("second", "three", "four", "first", "five")
                .containsAnyOf("tenth", "hundredth", "five")
                .doesNotContain("tenth", "hundredth", "zero")
                .containsSequence("first", "second");
    }
    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> array = simpleConvert.toSet("ten", "twenty", "thirty", "fourty", "fifty");
        assertThat(array)
                .first()
                .isEqualTo("fifty");
        assertThat(array)
                .element(0)
                .isNotNull()
                .isEqualTo("fifty");
        assertThat(array)
                .last()
                .isNotNull()
                .isEqualTo("thirty");
    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("ten", "twenty", "thirty", "fourty", "fifty");
        assertThat(map).hasSize(5)
                .containsKey("ten")
                .containsValue(1)
                .doesNotContainKey("first")
                .doesNotContainValue(100)
                .containsEntry("ten", 0);
    }
}