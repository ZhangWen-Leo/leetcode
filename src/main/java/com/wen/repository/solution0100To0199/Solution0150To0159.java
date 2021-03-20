package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0150To0159 {

    /**
     * 150. Evaluate Reverse Polish Notation
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token :
                tokens) {
            if (isOperator(token)) {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    stack.push(String.valueOf(num1 + num2));
                }
                else if (token.equals("-")) {
                    stack.push(String.valueOf(num1 - num2));
                }
                else if (token.equals("*")) {
                    stack.push(String.valueOf(num1 * num2));
                }
                else {
                    stack.push(String.valueOf(num1 / num2));
                }
            }
            else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }
    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 152. Maximum Product Subarray
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> zeroIndex = new ArrayList<>();
        zeroIndex.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
            }
        }
        zeroIndex.add(nums.length);

        int max = 0;
        for (int i = 0; i < zeroIndex.size() - 1; i++) {
            max = Math.max(max, calculateMaxWithoutZero(nums, zeroIndex.get(i)+1, zeroIndex.get(i+1)));
        }

        return max;
    }
    private int calculateMaxWithoutZero(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        int allProduct = 1;
        for (int i = start; i < end; i++) {
            allProduct *= nums[i];
        }

        if (allProduct < 0) {
            int left = allProduct, right = allProduct;
            for (int i = start; i < end - 1; i++) {
                if ((left = left / nums[i]) > 0) {
                    break;
                }
            }
            for (int i = end-1; i > start; i--) {
                if ((right = right / nums[i]) > 0) {
                    break;
                }
            }
            allProduct = Math.max(left, right);
        }

        return allProduct;
    }

    /**
     * 153. Find Minimum in Rotated Sorted Array
     *
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * All the integers of nums are unique.
     * nums is sorted and rotated between 1 and n times.
     */
    public int findMin154(int[] nums) {
        return findMin154(nums, 0, nums.length);
    }
    private int findMin154(int[] nums, int start, int end) {
        if (start == end) {
            return Integer.MAX_VALUE;
        }
        int middle = (start + end) / 2;
        if (middle == start) {
            return nums[start];
        }
        if (nums[middle] > nums[start]) {
            return Math.min(nums[start], findMin154(nums, middle+1, end));
        }
        else {
            return findMin154(nums, start+1, middle+1);
        }
    }

    /**
     * 154. Find Minimum in Rotated Sorted Array II
     */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length);
    }
    private int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return Integer.MAX_VALUE;
        }

        int middle = (start + end) / 2;
        if (middle == start) {
            return nums[start];
        }
        if (nums[middle] > nums[start]) {
            return Math.min(nums[start], findMin(nums, middle+1, end));
        }
        else if (nums[middle] < nums[start]) {
            return findMin(nums, start+1, middle+1);
        }
        else {
            return Math.min(findMin(nums, start, middle), findMin(nums, middle, end));
        }
    }

    /**
     * 155. Min Stack
     *
     * 见design
     */

    /**
     * 156. Binary Tree Upside Down
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        TreeNode p = root;
        while (p.left.left != null) {
            p = p.left;
        }
        TreeNode result = p.left;
        result.left = p.right;
        p.left = null;
        p.right = null;
        result.right = upsideDownBinaryTree(root);
        return result;
    }

    /**
     * 157. Read N Characters Given Read4
     *
     * 见design
     */

    /**
     * 158. Read N Characters Given Read4 II - Call multiple times
     *
     * 见design
     */

    /**
     * 159. Longest Substring with At Most Two Distinct Characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, second, secondEnd, end;
        int max = 0;

        end = start + 1;
        while (end < s.length() && s.charAt(end) == s.charAt(start)) {
            end++;
        }
        if (end >= s.length()) {
            return s.length();
        }
        second = end;
        while (start < s.length()) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(second);
            end = second + 1;
            while (end < s.length()) {
                if (s.charAt(end) == c1) {
                    second = end;
                    c1 = c2;
                    c2 = s.charAt(end);
                    end++;
                }
                else if (s.charAt(end) == c2) {
                    end++;
                }
                else {
                    break;
                }
            }
            if (end >= s.length()) {
                max = Math.max(max, end - start);
                break;
            }
            max = Math.max(max, end - start);
            start = second;
            second = end;
        }

        return max;
    }
}
