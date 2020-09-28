package com.wen.explore.read.arrayAndString;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublePointerTest {

    private DoublePointer doublePointer = new DoublePointer();

    @Test
    public void minSubArrayLen() {
        int[] a = new int[]{2,3,1,2,4,3};
        System.out.println(doublePointer.minSubArrayLen(7, a));
    }
}