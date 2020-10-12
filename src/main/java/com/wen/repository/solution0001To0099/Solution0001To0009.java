package com.wen.repository.solution0001To0099;

import java.util.*;

public class Solution0001To0009 {

    /**
     * 1. Two Sum
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            else {
                map.put(target - nums[i], i);
            }
        }

        throw new RuntimeException("错误的参数");
    }

    /**
     * 4. Median of Two Sorted Arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int start1 = 0, end1 = length1, start2 = 0, end2 = length2;

        while (true) {
            // 找出下一个最小值
            // 两个数组都未被检查完的情况
            if (start1 < end1 && start2 < end2) {
                // 只剩两个数未被检查,可以直接返回结果
                if (end1 - start1 + end2 - start2 == 2) {
                    return (nums1[start1] + nums2[start2]) / 2.0;
                }
                // 其他情况，先去掉最小数和最大数
                // 最小数
                if (nums1[start1] < nums2[start2]) {
                    start1++;
                }
                else {
                    start2++;
                }
                // 最大数
                // 仍然两个数组都未被检查完
                if (start1 < end1 && start2 < end2) {
                    if (nums1[end1-1] > nums2[end2-1]) {
                        end1--;
                    }
                    else {
                        end2--;
                    }
                }
                // 只剩nums1未被检查完
                else if (start1 < end1) {
                    end1--;
                }
                // 只剩nums2未被检查完
                else {
                    end2--;
                }
            }
            // 只有第一个数组未被检查完的情况
            else if (start1 < end1) {
                // 只剩一个数未被检查，可以直接返回结果
                if (end1 - start1 == 1) {
                    return nums1[start1];
                }
                // 只剩两个数
                else if (end1 - start1 == 2) {
                    return (nums1[start1] + nums1[end1-1]) / 2.0;
                }
                // 其他情况，去掉最小数和最大数
                start1++;
                end1--;
            }
            // 只有第二个数组未被检查完的情况
            else {
                if (end2 - start2 == 1) {
                    return nums2[start2];
                }
                else if (end2 - start2 == 2) {
                    return (nums2[start2] + nums2[end2-1]) / 2.0;
                }
                start2++;
                end2--;
            }
        }
    }

    /**
     * 6. ZigZag Conversion
     */
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= numRows; i++) {
            int increment1 = numRows - i, increment2 = i - 1, increment;
            if (increment1 == 0) {
                increment1 = increment2;
            }
            if (increment2 == 0) {
                increment2 = increment1;
            }
            increment1 *= 2;
            increment2 *= 2;
            if (increment1 == 0 && increment2 == 0) {
                increment1 = 1;
                increment2 = 1;
            }
            increment = increment2;
            for (int j = i-1; j < s.length(); j += increment) {
                result.append(s.charAt(j));
                increment = increment == increment1 ? increment2 : increment1;
            }
        }

        return result.toString();
    }

    /**
     * 9. Palindrome Number
     */
    public boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();

        if (x == 0) {
            return true;
        }
        else if (x < 0) {
            return false;
        }

        int n = x;
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }

        long palindromeNum = 0;
        for (Integer i :
                list) {
            palindromeNum = palindromeNum*10 + i;
        }

        return palindromeNum == x;
    }
}
