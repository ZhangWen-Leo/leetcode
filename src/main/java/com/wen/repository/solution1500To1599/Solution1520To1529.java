package com.wen.repository.solution1500To1599;

import java.util.ArrayList;
import java.util.List;

public class Solution1520To1529 {

    /**
     * 1526. Minimum Number of Increments on Subarrays to Form a Target Array
     */
    public int minNumberOperations(int[] target) {
        if (target.length == 0) {
            return 0;
        }

        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int status = 1; // -1表示下降，1表示上升

        for (int i = 0; i < target.length-1; i++) {
            if (target[i] > target[i+1]) {
                if (status == 1) {
                    maxList.add(i);
                }
                status = -1;
            }
            else if (target[i] < target[i+1]) {
                if (status == -1) {
                    minList.add(i);
                }
                status = 1;
            }
        }
        if (status == 1) {
            maxList.add(target.length-1);
        }

        int count = target[maxList.get(0)];
        for (int i = 1; i < maxList.size(); i++) {
            count += target[maxList.get(i)] - target[minList.get(i-1)];
        }
        return count;
    }
}
