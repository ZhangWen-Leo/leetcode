package com.wen.repository.solution1200To1299;

import java.util.*;

public class Solution1200To1209 {

    /**
     * 1207. Unique Number of Occurrences
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] index = new int[arr.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = 1001;
        }
        for (Integer key:
                map.keySet()) {
            if (index[map.get(key)] < 1001) {
                return false;
            }
            else {
                index[map.get(key)] = key;
            }
        }
        return true;
    }
}
