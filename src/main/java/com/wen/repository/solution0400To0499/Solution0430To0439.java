package com.wen.repository.solution0400To0499;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0430To0439 {

    /**
     * 435. Non-overlapping Intervals
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        int length = intervals.length;
        boolean[] wiLLRemove = new boolean[length];
        int removeCount = 0;
        for (int i = 0; i < length; i++) {
            int preMax = Integer.MIN_VALUE;
            int j = i - 1;
            while (j >= 0 && wiLLRemove[j]) {
                j--;
            }
            if (j >= 0 && intervals[i][0] < intervals[j][1]) {
                if (intervals[i][1] > intervals[j][1]) {
                    wiLLRemove[i] = true;
                }
                else {
                    wiLLRemove[j] = true;
                }
                removeCount++;
            }
        }

        return removeCount;
    }
}
