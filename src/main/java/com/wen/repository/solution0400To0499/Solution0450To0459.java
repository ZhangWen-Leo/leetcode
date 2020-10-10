package com.wen.repository.solution0400To0499;

import java.util.HashMap;
import java.util.Map;

public class Solution0450To0459 {

    /**
     * 454. 4Sum II
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length, count = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        Map<Integer, Integer> mapCD = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int key = A[i] + B[j];
                mapAB.put(key, mapAB.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int key = C[i] + D[j];
                mapCD.put(key, mapCD.getOrDefault(key, 0) + 1);
            }
        }

        for (Integer key :
                mapAB.keySet()) {
            count += mapAB.getOrDefault(key, 0) * mapCD.getOrDefault(-key, 0);
        }

        return count;
    }
}
