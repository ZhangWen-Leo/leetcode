package com.wen.repository.solution1300To1399;

import java.util.*;

public class Solution1350To1359 {

    /**
     * 1356. Sort Integers by The Number of 1 Bits
     *
     * 1 <= arr.length <= 500
     * 0 <= arr[i] <= 10^4
     */
    public int[] sortByBits(int[] arr) {
        return arr;
    }
    /**
     * 解法2
     * 8ms      51.98%
     */
    public int[] sortByBits2(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] counts = new int[length],
                result = new int[length];
        for (int i = 0; i < length; i++) {
            counts[i] = calculateNumOf1(arr[i]);
        }

        int index = 0;
        for (int i = 0; i < 14 && index < length; i++) {
            for (int j = 0; j < length && index < length; j++) {
                if (counts[j] == i) {
                    result[index++] = arr[j];
                }
            }
        }

        return result;
    }
    /**
     * 解法1
     * 26ms         13.55%
     */
    public int[] sortByBits1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) - map.get(o2) == 0) {
                    return o1 - o2;
                }
                else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });
        for (int num :
                arr) {
            map.put(num, calculateNumOf1(num));
            queue.offer(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }

        return arr;
    }
    private int calculateNumOf1(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }

        return count;
    }
}
