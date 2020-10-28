package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.*;

public class Solution0120To0129 {

    /**
     * 124. Binary Tree Maximum Path Sum
     *
     * The number of nodes in the tree is in the range [0, 3 * 104].
     * -1000 <= Node.val <= 1000
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return myMaxPathSum(root)[1];
    }
    private int[] myMaxPathSum(TreeNode root) {
        int[] leftMax = root.left == null ? null : myMaxPathSum(root.left);
        int[] rightMax = root.right == null ? null : myMaxPathSum(root.right);

        int[] result = new int[]{root.val, root.val};

        if (leftMax != null && rightMax != null) {
            result[0] += Integer.max(0, Integer.max(leftMax[0], rightMax[0]));
            result[1] += Integer.max(0, leftMax[0]) + Integer.max(0, rightMax[0]);
        }
        else if (leftMax != null) {
            result[0] += Integer.max(0, leftMax[0]);
            result[1] += Integer.max(0, leftMax[0]);
        }
        else if (rightMax != null && rightMax[0] > 0) {
            result[0] += Integer.max(0, rightMax[0]);
            result[1] += Integer.max(0, rightMax[0]);
        }

        if (leftMax != null || rightMax != null) {
            if (leftMax != null) {
                result[1] = Integer.max(result[1], leftMax[1]);
            }
            if (rightMax != null) {
                result[1] = Integer.max(result[1], rightMax[1]);
            }
        }
        return result;
    }

    /**
     * 128. Longest Consecutive Sequence
     *
     * 0 <= nums.length <= 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num :
                nums) {
            set.add(num);
        }

        int max = 0;
        for (int num :
                nums) {
            if (set.contains(num)) {
                max = Integer.max(max, deleteInSet(set, num));
            }
        }

        return max;
    }
    private int deleteInSet(Set<Integer> set, int num) {
        if (set.contains(num)) {
            set.remove(num);
            return 1 +
                    (num == Integer.MIN_VALUE ? 0 : deleteInSet(set, num - 1)) +
                    (num == Integer.MAX_VALUE ? 0 : deleteInSet(set, num + 1));
        }
        else {
            return 0;
        }
    }

}
