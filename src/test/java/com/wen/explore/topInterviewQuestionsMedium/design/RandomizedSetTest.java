package com.wen.explore.topInterviewQuestionsMedium.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedSetTest {

    private RandomizedSet randomizedSet = new RandomizedSet();

    @Test
    public void insert() {
        randomizedSet.insert(10);
        randomizedSet.insert(50);
        randomizedSet.insert(30);
        randomizedSet.insert(10);
        randomizedSet.insert(2);
        randomizedSet.insert(0);
        System.out.println(randomizedSet);
    }

    @Test
    public void remove() {
        randomizedSet.insert(10);
        randomizedSet.insert(50);
        randomizedSet.insert(30);
        randomizedSet.insert(10);
        randomizedSet.insert(2);
        randomizedSet.insert(0);
        randomizedSet.remove(30);
        System.out.println(randomizedSet);
    }

    @Test
    public void getRandom() {
        randomizedSet.insert(10);
        randomizedSet.insert(50);
        randomizedSet.insert(30);
        randomizedSet.insert(10);
        randomizedSet.insert(2);
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
    }

    @Test
    public void test() {
        System.out.println(randomizedSet.insert(1));;
        System.out.println(randomizedSet.remove(2));;
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}