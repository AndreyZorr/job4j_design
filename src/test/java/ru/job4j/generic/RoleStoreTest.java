package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRolenameIsEva() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Eva"));
        Role result = store.findById("3");
        assertThat(result.getUsername()).isEqualTo("Eva");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Eva"));
        Role result = store.findById("22");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsEvA() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        store.add(new Role("2", "Vika"));
        Role result = store.findById("2");
        assertThat(result.getUsername()).isEqualTo("Eva");
    }

    @Test
    void whenReplaceThenRolenameIsVika() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        store.replace("2", new Role("2", "Vika"));
        Role result = store.findById("2");
        assertThat(result.getUsername()).isEqualTo("Vika");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        store.replace("10", new Role("10", "Vika"));
        Role result = store.findById("2");
        assertThat(result.getUsername()).isEqualTo("Eva");
    }

    @Test
    void whenDeleteUserThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        store.delete("2");
        Role result = store.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenRolenameIsEva() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        store.delete("10");
        Role result = store.findById("2");
        assertThat(result.getUsername()).isEqualTo("Eva");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Eva"));
        boolean result = store.replace("2", new Role("2", "Vika"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eva"));
        boolean result = store.replace("10", new Role("10", "Vika"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eva"));
        boolean result = store.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Eva"));
        boolean result = store.delete("2");
        assertThat(result).isFalse();
    }
}
