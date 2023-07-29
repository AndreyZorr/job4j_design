package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {

        int added = 0;
        int changed = 0;
        int removed = 0;

        HashMap<Integer, User> map = new HashMap<>();

        for (var c : previous) {
            map.put(c.getId(), c);
        }
        for (var p : current) {
            if (!map.containsKey(p.getId())) {
                added++;
            }
            if (!map.containsValue(p) && map.containsKey(p.getId())) {
                changed++;
            }
            map.remove(p.getId());
        }
        removed = map.size();
        return new Info(added, changed, removed);
    }
}
