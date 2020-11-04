package com.wen.repository.solution0300To0399;

import com.wen.dataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0310To0319 {

    /**
     * 312. Burst Balloons
     * You may imagine nums[-1] = nums[n] = 1.
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     */
    private int[] balloonNums;
    private int[][] balloonResults;
    public int maxCoins(int[] nums) {
        int length = nums.length;
        balloonNums = nums;
        balloonResults = new int[length][length];

        return solve(-1, length);
    }
    private int solve(int start, int end) {
        if (end - start == 1) {
            return 0;
        }
        else if (balloonResults[start+1][end-1] != 0) {
            return balloonResults[start+1][end-1];
        }

        int max = 0;
        for (int i = start + 1; i < end; i++) {
            max = Integer.max(max, getNum(start)*getNum(i)*getNum(end) + solve(start, i) + solve(i, end));
        }

        balloonResults[start+1][end-1] = max;
        return max;
    }
    private int getNum(int i) {
        return i >= 0 && i < balloonNums.length ? balloonNums[i] : 1;
    }

    /**
     * 315. Count of Smaller Numbers After Self
     * TODO
     */
    public List<Integer> countSmaller(int[] nums) {
        Node head = new Node();
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(0);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int count = 0;
            Node p = head, node = new Node(nums[i]);
            while (p.next != null && p.next.val < nums[i]) {
                p = p.next;
                count++;
            }
            node.next = p.next;
            p.next = node;
            list.set(i, count);
        }

        return list;
    }
}
