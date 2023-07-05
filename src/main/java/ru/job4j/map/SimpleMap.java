package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int hashCodeKey = hash(Objects.hashCode(key));
        int index = indexFor(hashCodeKey);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int getIndex(K key) {
        return indexFor(hash(key == null ? 0 : key.hashCode()));
    }

    private void expand() {
        capacity += capacity;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = getIndex(entry.key);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int hashCodeKey = hash(Objects.hashCode(key));
        int index = indexFor(hashCodeKey);
        if (table[index] != null) {
            int hashCodeKey2 = hash(Objects.hashCode(table[index].key));
            if (hashCodeKey == hashCodeKey2) {
                if (Objects.equals(key, table[index].key)) {
                    result = table[index].value;
                }
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int cursor;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < capacity && table[cursor] == null) {
                    cursor++;
                }
                return cursor < capacity;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}