package com.wen.repository.solution1000To1099;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1010To1019 {

    /**
     * 1018. Binary Prefix Divisible By 5
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);

        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = ((num<<1) + A[i]) % 5;
            result.add(num==0);
        }
        return result;
    }
}
