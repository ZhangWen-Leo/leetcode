package com.wen.repository.solution0900To0999;

import java.util.LinkedList;
import java.util.List;

public class Solution0980To0989 {

    /**
     * 989. Add to Array-Form of Integer
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int current = 0;

        for (int i = A.length-1; i >= 0; i--) {
            if (K > 0) {
                current += K % 10;
                K /= 10;
            }

            current += A[i];
            result.add(0, current % 10);
            current /= 10;
        }

        while (K > 0) {
            current += K % 10;
            result.add(0, current % 10);
            current /= 10;
            K /= 10;
        }
        if (current > 0) {
            result.add(0, current);
        }

        return result;
    }
}
