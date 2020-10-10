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
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num :
                nums) {
            if (queue.size() < k) {
                queue.offer(num);
            }
            else if (num > queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }

        return queue.peek();
    }

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
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

        int currentMin = intervals[0][0], currentMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentMax) {
                currentMax = Math.max(currentMax, intervals[i][1]);
            }
            else {
                list.add(new int[]{currentMin, currentMax});
                currentMin = intervals[i][0];
                currentMax = intervals[i][1];
            }
        }
        list.add(new int[]{currentMin, currentMax});

        return list.toArray(new int[0][]);
    }

    /**
     * 搜索旋转排序数组
     */
    public int search(int[] nums, int target) {
        return rotatedSearch(nums, target, 0, nums.length);
    }
    private int rotatedSearch(int[] nums, int target, int start, int end) {
        int i = (start + end) / 2, result;
        if (start >= end) {
            return -1;
        }
        if (nums[i] == target) {
            return i;
        }
        else if (nums[i] > target) {
            if (nums[i] >= nums[start]) {
                if (target >= nums[start]) {
                    result = Arrays.binarySearch(nums, start, i, target);
                    return result >= 0 ? result : -1;
                }
                else if (target <= nums[end-1]) {
                    return rotatedSearch(nums, target, i+1, end);
                }
                else {
                    return -1;
                }
            }
            else {
                return rotatedSearch(nums, target, start, i);
            }
        }
        else {
            if (nums[i] >= nums[start]) {
                return rotatedSearch(nums, target, i+1, end);
            }
            else {
                if (target >= nums[start]) {
                    return rotatedSearch(nums, target, start, i);
                }
                else if (target <= nums[end-1]) {
                    result = Arrays.binarySearch(nums, i+1, end, target);
                    return result >= 0 ? result : -1;
                }
                else {
                    return -1;
                }
            }
        }
    }

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
