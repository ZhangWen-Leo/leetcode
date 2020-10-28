package com.wen.repository.solution0100To0199.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 */
public class LRUCache {
    LinkedList<Integer> list;
    Map<Integer, Integer> map;
    int capacity = 0;
    int size = 0;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.removeFirstOccurrence(key);
            list.addLast(key);
            return map.get(key);
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.removeFirstOccurrence(key);
        }
        else if (size >= capacity) {
            map.remove(list.getFirst());
            list.removeFirst();
        }
        else {
            size++;
        }
        map.put(key, value);
        list.addLast(key);
    }
}
