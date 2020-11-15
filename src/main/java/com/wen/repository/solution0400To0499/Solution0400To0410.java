package com.wen.repository.solution0400To0499;

import com.wen.dataStructure.TreeNode;

public class Solution0400To0410 {

    /**
     * 402. Remove K Digits
     */
    public String removeKdigits(String num, int k) {
        String result = removeKdigits(num, k, true);

        return result.length() == 0 ? "0" : result;
    }
    private String removeKdigits(String num, int k, boolean head) {
        if (k == 0) {
            return num;
        }
        if (k == num.length()) {
            return "";
        }

        char min = num.charAt(0);
        int minIndex = 0;
        for (int i = 1; i <= k; i++) {
            char c = num.charAt(i);
            if (c < min) {
                min = c;
                minIndex = i;
            }
        }

        return (head && min == '0')
                ? removeKdigits(num.substring(minIndex + 1), k - minIndex, true)
                : min + removeKdigits(num.substring(minIndex + 1), k - minIndex, false);
    }
    /**
     * 解法1
     * 18ms     20.21%
     */
    public String removeKdigits1(String num, int k) {
        StringBuilder result = new StringBuilder();
        int remove = 0, start = 0, end = num.length();
        boolean head = true;

        while (remove < k) {
            char min = '9';
            int minIndex = 0;
            if (k - remove == end - start) {
                end = start;
                break;
            }
            for (int i = 0; start + i < num.length() && i < k - remove + 1; i++) {
                char c = num.charAt(start + i);
                if (c < min) {
                    min = c;
                    minIndex = i;
                }
            }

            if (!head) {
                result.append(min);
            }
            else if (min != '0') {
                result.append(min);
                head = false;
            }
            remove += minIndex;
            start += minIndex + 1;
        }
        result.append(num, start, end);

        if (result.length() == 0) {
            result.append('0');
        }
        return result.toString();
    }

    /**
     * 404. 左叶子之和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return mySumOfLeftLeaves(root, false);
    }
    private int mySumOfLeftLeaves(TreeNode root, boolean isLeft) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            sum += isLeft ? root.val : 0;
        }
        else {
            if (root.left != null) {
                sum += mySumOfLeftLeaves(root.left, true);
            }
            if (root.right != null) {
                sum += mySumOfLeftLeaves(root.right, false);
            }
        }
        return sum;
    }
}
