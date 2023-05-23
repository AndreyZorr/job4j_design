package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .contains("Cu")
                .doesNotContain("here")
                .isEqualTo("Cube");
    }
    @Test
    void isThisSphere() {
        Box box = new Box(0, 3);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .contains("he")
                .doesNotContain("be")
                .isEqualTo("Sphere");
    }

    @Test
    void getNumberOfVertices1() {
        Box box = new Box(1, 3);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isNotPositive()
                .isEqualTo(-1);
    }

    @Test
    void getNumberOfVertices4() {
        Box box = new Box(4, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void isExistFalse() {
        Box box = new Box(2, 2);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 6);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 1);
        double result = box.getArea();
        assertThat(result).isEqualTo(12.6d, withPrecision(0.06d))
                .isGreaterThan(12.5d)
                .isLessThan(148.4d);
    }
    @Test
    void  getAreaCube() {
        Box box = new Box(8, 20);
        double result = box.getArea();
        assertThat(result).isEqualTo(2400.0, withPrecision(0.006d))
                .isGreaterThan(950.98)
                .isLessThan(5000.8);
    }
}