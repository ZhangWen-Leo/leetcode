package com.wen.repository.solution0900To0999;

import java.util.HashMap;

public class Solution0990To0999 {

    /**
     * 992. Subarrays with K Different Integers
     *
     * TODO
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int len = A.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        while (left < len - K + 1) {
            if (map.keySet().size() < K) {
                while (map.keySet().size() < K && right < len) {
                    map.put(A[right], map.getOrDefault(A[right], 0) + 1);
                    right++;
                }
                if (map.keySet().size() != K) {
                    break;
                }
                res++;
                while (right < len && map.keySet().contains(A[right])) {
                    map.put(A[right], map.get(A[right]) + 1);
                    res++;
                    right++;
                }
            }
            else {
                res++;
                while (right > left && map.get(A[right-1]) != 1) {
                    map.put(A[right-1], map.get(A[right-1]) - 1);
                    res++;
                    right--;
                }
            }
            if (map.get(A[left]) == 1) {
                map.remove(A[left]);
            }
            else {
                map.put(A[left], map.get(A[left]) - 1);
            }
            left++;
        }

        return res;
    }
}
