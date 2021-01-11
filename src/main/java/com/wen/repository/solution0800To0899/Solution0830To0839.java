package com.wen.repository.solution0800To0899;

import java.util.ArrayList;
import java.util.List;

public class Solution0830To0839 {

    /**
     * 830. Positions of Large Groups
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        int start = 0;
        while (start < s.length()) {
            char c = s.charAt(start);
            int end = start;
            while (end < s.length() && s.charAt(end) == c) {
                end++;
            }
            if (end - start >= 3) {
                List<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end - 1);
                result.add(interval);
            }
            start = end;
        }

        return result;
    }

    /**
     * 834. Sum of Distances in Tree
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        // 排列各点等级
        

        return null;
    }
}
