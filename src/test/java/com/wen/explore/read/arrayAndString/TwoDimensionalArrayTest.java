package com.wen.explore.read.arrayAndString;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoDimensionalArrayTest {

    private TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray();

    @Test
    public void rotate() {
        int[][] a = {
                {1,2,3},
                {5,6,7},
                {9,10,11}
//                {13,14,15,16}
        };
        twoDimensionalArray.rotate(a);
        for (int[] b :
                a) {
            System.out.println(Arrays.toString(b));
        }
    }
}