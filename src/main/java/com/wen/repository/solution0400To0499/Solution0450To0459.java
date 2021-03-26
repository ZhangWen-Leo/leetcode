package com.wen.repository.solution0400To0499;

import java.util.*;

public class Solution0450To0459 {

    /**
     * 454. 4Sum II
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length, count = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        Map<Integer, Integer> mapCD = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int key = A[i] + B[j];
                mapAB.put(key, mapAB.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int key = C[i] + D[j];
                mapCD.put(key, mapCD.getOrDefault(key, 0) + 1);
            }
        }

        for (Integer key :
                mapAB.keySet()) {
            count += mapAB.getOrDefault(key, 0) * mapCD.getOrDefault(-key, 0);
        }

        return count;
    }

    /**
     * 455. Assign Cookies
     *
     * 1 <= g.length <= 3 * 10^4
     * 0 <= s.length <= 3 * 10^4
     * 1 <= g[i], s[j] <= 2^31 - 1
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }
            if (j < s.length) {
                i++;
                j++;
            }
            else {
                break;
            }
        }

        return i;
    }

    /**
     * 456. 132 Pattern
     *
     * 找到三个数a,b,c，按顺序满足a<c<b
     *
     * n == nums.length
     * 1 <= n <= 10^4
     * -10^9 <= nums[i] <= 10^9
     *
     * @param nums  数组
     * @return  数组中是否存在132模式
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        int start = 1;
        while (start < len && nums[start] <= nums[start - 1]) {
            start++;
        }
        if (start >= len) {
            return false;
        }
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{nums[start - 1], nums[start]});

        for (int i = start + 1; i < len; i++) {
            if (nums[i] > list.getFirst()[1]) {
                Iterator<int[]> iterator = list.listIterator();
                int[] interval = iterator.next();
                interval[1] = nums[i];
                while (iterator.hasNext()) {
                    interval = iterator.next();
                    if (nums[i] >= interval[1]) {
                        iterator.remove();
                    }
                    else if (nums[i] > interval[0]) {
                        return true;
                    }
                    else {
                        break;
                    }
                }
            }
            else if (nums[i] < list.getFirst()[0]) {
                while (i < len && nums[i] <= nums[i - 1]) {
                    i++;
                }
                if (i >= len) {
                    return false;
                }

                list.addFirst(new int[]{nums[i - 1], nums[i - 1]});
                i--;
            }
            else if (nums[i] < list.getFirst()[1] && nums[i] > list.getFirst()[0]) {
                return true;
            }
        }

        return false;
    }
}
