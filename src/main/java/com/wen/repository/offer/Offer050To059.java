package com.wen.repository.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer050To059 {
    /**
     * 58 - II. 左旋转字符串
     */
    public String reverseLeftWords(String s, int n) {
        if (n >= s.length() || n < 0) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 59 - I. 滑动窗口的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        // 大顶堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 确定第一个窗口中最大的数
        result[0] = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            result[0] = Integer.max(result[0], nums[i]);
        }

        // 遍历之后的窗口
        for (int i = 0; i + k < nums.length; i++) {
            queue.remove(nums[i]);
            queue.offer(nums[i+k]);
            result[i+1] = queue.peek();
        }

        return result;
    }
}
