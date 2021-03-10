package com.wen.explore.topInterviewQuestionsMedium;

import java.util.*;

public class SortAndSearch {
    /**
     * 颜色分类
     * 见：75
     */

    /**
     * 前 K 个高频元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        queue.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    /**
     * 数组中的第K个最大元素
     *
     * 见215
     */

    /**
     * 寻找峰值
     */
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length, i = 0;
        while (start < end) {
            i = (start+end) / 2;
            if (i == 0 || i == nums.length-1) {
                if (end - start == 2) {
                    return nums[i] > nums[start] ? i : start;
                }
                else {
                    return i;
                }
            }
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
            if (nums[i] > nums[i-1]) {
                start = i+1;
            }
            else {
                end = i;
            }
        }
        return i;
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[] {i, i};
        while (result[0] > 0 && nums[result[0]-1] == target) {
            result[0]--;
        }
        while (result[1] < nums.length-1 && nums[result[1]+1] == target) {
            result[1]++;
        }
        return result;
    }

    /**
     * 合并区间
     * 见56
     */

    /**
     * 搜索旋转排序数组
     * 见33
     */

    /**
     * 搜索二维矩阵 II
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int minX = 0, minY = 0, maxX = matrix.length-1, maxY = matrix[0].length-1;
        while (minX <= maxX && minY <= maxY) {
            if (minX < maxX || minY < maxY) {
                int leftDown = matrix[maxX][minY], rightUp = matrix[minX][maxY];
                if (leftDown > target) {
                    maxX--;
                }
                else if (leftDown < target) {
                    minY++;
                }
                else {
                    return true;
                }
                if (rightUp > target) {
                    maxY--;
                }
                else if (rightUp < target) {
                    minX++;
                }
                else {
                    return true;
                }
            }
            if (maxX == minX && maxY == minY) {
                return matrix[minX][minY] == target;
            }
        }
        return false;
    }
}
