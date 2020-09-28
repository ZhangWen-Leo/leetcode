package com.wen.explore.read.arrayAndString;

import java.util.Arrays;

public class DoublePointer {
    /**
     * 反转字符串
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

    /**
     * 数组拆分 I
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    /**
     * 两数之和 II - 输入有序数组
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
            else if (numbers[i] + numbers[j] < target) {
                i++;
            }
            else {
                return new int[]{i+1, j+1};
            }
        }

        return new int[0];
    }

    /**
     * 移除元素
     */
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
            }
            else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    /**
     * 最大连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int fast = 0, slow = 0, max = 0;

        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            slow = fast;
            while (fast < nums.length && nums[fast] == 1) {
                fast++;
            }
            max = Integer.max(fast - slow, max);
        }

        return max;
    }

    /**
     * 长度最小的子数组
     */
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0, slow = 0, sum = 0, min = Integer.MAX_VALUE;

        while (fast <= nums.length) {
            if (sum < s) {
                if (fast < nums.length) {
                    sum += nums[fast++];
                }
                else {
                    break;
                }
            }
            else {
                min = Integer.min(fast - slow, min);
                sum -= nums[slow++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
