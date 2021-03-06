package com.wen.repository.solution0500To0599;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0500To0510 {

    /**
     * 501. 二叉搜索树中的众数
     */
    List<Integer> list = new ArrayList<>();
    int maxCount = Integer.MIN_VALUE;
    int lastNum = Integer.MIN_VALUE+1;
    int count = 0;
    public int[] findMode(TreeNode root) {
        list.clear();

        inOrderSearch(root);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    private void inOrderSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderSearch(root.left);
        if (root.val != lastNum) {
            count = 1;
            if (count > maxCount) {
                list.add(root.val);
                maxCount = count;
            }
            else if (count == maxCount) {
                list.add(root.val);
            }
        }
        else {
            if (++count > maxCount) {
                list.clear();
                list.add(root.val);
                maxCount = count;
            }
            else if (count == maxCount) {
                list.add(root.val);
            }
        }
        lastNum = root.val;
        inOrderSearch(root.right);
    }

    /**
     * 503. Next Greater Element II
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE, maxIndex = 0;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int i = maxIndex;
        do {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            }
            else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);

            i = nextIndex(i, -1, len);
        } while (i != maxIndex);

        return res;
    }
    private int nextIndex(int cur, int ins, int len) {
        cur += ins;
        if (cur >= len) {
            cur %= len;
        }
        while (cur < 0) {
            cur += len;
        }
        return cur;
    }

    /**
     * 509. Fibonacci Number
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, temp;
        while (n-- > 2) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return a + b;
    }
}
