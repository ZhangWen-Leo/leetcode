package com.wen.explore.read.arrayAndString;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBasicTest {

    private ArrayBasic arrayBasic = new ArrayBasic();

    @Test
    public void pivotIndex() {
        int[] a = {1,7,3,6,5,6};
        System.out.println(arrayBasic.pivotIndex(a));
    }
}