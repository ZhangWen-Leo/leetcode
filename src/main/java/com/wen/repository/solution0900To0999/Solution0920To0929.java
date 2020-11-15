package com.wen.repository.solution0900To0999;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0920To0929 {

    /**
     * 922. Sort Array By Parity II
     */
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while (even < A.length && odd < A.length) {
            while (even < A.length && A[even] % 2 == 0) {
                even += 2;
            }

            while (odd < A.length && A[odd] % 2 != 0) {
                odd += 2;
            }

            if (odd < A.length && even < A.length) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }

        return A;
    }

    /**
     * 925. Long Pressed Name
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            char c = name.charAt(i);
            int count = 1;
            i++;
            while (i < name.length() && name.charAt(i) == c) {
                i++;
                count++;
            }

            while (count > 0) {
                if (j >= typed.length() || typed.charAt(j) != c) {
                    return false;
                }
                else {
                    count--;
                    j++;
                }
            }
            while (j < typed.length() && typed.charAt(j) == c) {
                j++;
            }
        }
        if (i < name.length() || j < typed.length()) {
            return false;
        }
        else {
            return true;
        }
    }
}
