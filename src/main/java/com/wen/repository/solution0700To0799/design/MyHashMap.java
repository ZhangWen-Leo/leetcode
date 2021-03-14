package com.wen.repository.solution0700To0799.design;

import java.util.HashMap;

public class MyHashMap {

    HashMap<Integer, Integer> hashMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new HashMap<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap.put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        else {
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap.remove(key);
    }
}
