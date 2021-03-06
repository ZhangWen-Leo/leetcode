package com.wen.repository.solution0001To0099;

import java.util.*;

public class Solution0010To0019 {
    /**
     * 10. Regular Expression Matching
     * TODO
     */
    public boolean isMatch(String s, String p) {
        return false;
    }

    /**
     * 11. Container With Most Water
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (i < j) {
            max = Integer.max(max, Integer.min(height[i], height[j]) * (j - i));

            if (height[i] <= height[j]) {
                int k = i;
                while (k < j && height[k] <= height[i]) {
                    k++;
                }
                i = k;
            }
            else {
                int k = j;
                while (i < k && height[k] <= height[j]) {
                    k--;
                }
                j = k;
            }
        }

        return max;
    }

    /**
     * 12. Integer to Roman
     */
    public String intToRoman(int num) {
        int m, c, x, i;
        int copy = num;
        StringBuilder result = new StringBuilder();

        m = copy / 1000;
        copy %= 1000;
        c = copy / 100;
        copy %= 100;
        x = copy / 10;
        copy %= 10;
        i = copy;

        // 处理千位数
        while (m-- > 0) {
            result.append('M');
        }
        // 处理百位
        myIntToRoman(result, c, 'C', 'D', 'M');
        // 处理十位
        myIntToRoman(result, x, 'X', 'L', 'C');
        // 处理个位
        myIntToRoman(result, i, 'I', 'V', 'X');

        return result.toString();
    }
    private void myIntToRoman(StringBuilder s, int count, char i, char v, char x) {
        switch (count) {
            case 9: {
                s.append(i);
                s.append(x);
                break;
            }
            case 8: case 7: case 6: case 5: {
                s.append(v);
                while (count-- > 5) {
                    s.append(i);
                }
                break;
            }
            case 4: {
                s.append(i);
                s.append(v);
                break;
            }
            case 3: case 2: case 1: case 0: {
                while (count-- > 0) {
                    s.append(i);
                }
                break;
            }
            default: {
                throw new RuntimeException("计算出错");
            }
        }
        return;
    }

    /**
     * 15. 3Sum
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            Set<List<Integer>> sets = twoSumForThreeSum(nums, i + 1, -nums[i]);

            for (List<Integer> set :
                    sets) {
                List<Integer> list = new ArrayList<>();
                list.addAll(set);
                list.add(nums[i]);
                result.add(list);
            }

            i++;
            while (i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return result;
    }
    private Set<List<Integer>> twoSumForThreeSum(int[] nums, int start, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (start >= nums.length - 1) {
            return result;
        }
        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(target - nums[i]);
                result.add(list);
            }
            else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }

    /**
     * 16. 3Sum Closest
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new RuntimeException("没有3个数");
        }

        Arrays.sort(nums);
        int[] threeNums = {0, 1, 2};
        int oldClosestSum = calculateSum(nums, threeNums);
        int newClosestSum = oldClosestSum;

        while (newClosestSum < target) {
            int max = Integer.MIN_VALUE, maxIndex = -1;
            int min = Integer.MAX_VALUE, minIndex = -1;

            for (int i = 0; i < threeNums.length; i++) {
                if (
                        (i < threeNums.length-1 && threeNums[i] + 1 < threeNums[i+1])
                        || (i == threeNums.length-1 && threeNums[i] < nums.length-1)
                ) {
                    int diff = nums[threeNums[i]+1] - nums[threeNums[i]];

                    if (newClosestSum + diff < target && diff < max) {
                        max = diff;
                        maxIndex = i;
                    }
                    if (diff < min) {
                        min = diff;
                        minIndex = i;
                    }
                }
            }

            if (maxIndex != -1) {
                oldClosestSum = newClosestSum;
                newClosestSum += max;
                threeNums[maxIndex]++;
            }
            else if (minIndex != -1) {
                oldClosestSum = newClosestSum;
                newClosestSum += min;
                threeNums[minIndex]++;
            }
            else {
                break;
            }
        }

        if (newClosestSum > target) {
            return Math.abs(newClosestSum-target) - Math.abs(oldClosestSum-target) > 0 ? oldClosestSum : newClosestSum;
        }
        else {
            return newClosestSum;
        }
    }
    private int calculateSum(int[] nums, int[] indexes) {
        int sum = 0;
        for (int index :
                indexes) {
            sum += nums[index];
        }
        return sum;
    }

    /**
     * 18. 4Sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                Set<List<Integer>> set = twoSumForFourSum(nums, j+1, target - nums[i] - nums[j]);
                for (List<Integer> list :
                        set) {
                    list.add(0, nums[j]);
                    list.add(0, nums[i]);
                    resultSet.add(list);
                }
            }
        }

        result.addAll(resultSet);
        return result;
    }
    private Set<List<Integer>> twoSumForFourSum(int[] nums, int start, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (start >= nums.length - 1) {
            return result;
        }
        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(target - nums[i]);
                list.add(nums[i]);
                result.add(list);
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
