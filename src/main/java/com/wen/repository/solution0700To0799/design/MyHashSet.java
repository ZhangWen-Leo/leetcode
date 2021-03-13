package com.wen.repository.solution0700To0799.design;

import java.util.HashSet;

/**
 * 705. Design HashSet
 *
 * 设计HashSet
 *
 * TODO
 * 时间关系，先直接使用内部HashSet实现
 */
public class MyHashSet {

    HashSet<Integer> set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new HashSet<>();
    }

    public void add(int key) {
        set.add(key);
    }

    public void remove(int key) {
        set.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set.contains(key);
    }
}
