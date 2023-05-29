package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayItTest {

    @Test
    void whenMultiCallHasNextThenTrue() {
        ArrayIt iterator = new ArrayIt(
                new int[] {1, 2, 3}
        );
        boolean result = iterator.hasNext();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenReadSequence() {
        ArrayIt iterator = new ArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }
    @Test
    public void whenNextFromEmpty() {
        ArrayIt iterator = new ArrayIt(
                new int[] {}
        );
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}