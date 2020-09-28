package com.wen.explore.read.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayBasic {
    /**
     * 寻找数组的中心索引
     */
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int sum = 0;

        for (int num :
                nums) {
            sum += num;
        }

        int i = 0, left = 0, right = sum - nums[0];
        if (left == right) {
            return i;
        }
        while (i < nums.length-1) {
            left += nums[i++];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 合并区间
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        if (intervals.length > 0) {
            if (intervals[0].length > 0) {
                int currentMin = intervals[0][0], currentMax = intervals[0][1];
                for (int i = 1; i < intervals.length; i++) {
                    if (intervals[i][0] <= currentMax) {
                        currentMax = Integer.max(currentMax, intervals[i][1]);
                    }
                    else {
                        result.add(new int[]{currentMin, currentMax});
                        currentMin = intervals[i][0];
                        currentMax = intervals[i][1];
                    }
                }
                result.add(new int[]{currentMin, currentMax});
            }
            else {
                result.add(new int[0]);
            }
        }

        return result.toArray(new int[0][]);
    }
}
