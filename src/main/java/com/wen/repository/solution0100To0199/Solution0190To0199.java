package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0190To0199 {

    /**
     * 191. Number of 1 Bits
     */
    public int hammingWeight(int n) {
        int x = 31;
        int result;
        if (n >= 0) {
            result = 0;
            while (x-- > 0) {
                if (n % 2 == 1) {
                    result++;
                }
                n >>= 1;
            }
        }
        else {
            result = 1;
            while (x-- > 0) {
                if (n % 2 != 0) {
                    result++;
                }
                n >>= 1;
            }
        }
        return result;
    }

    /**
     * 192-195 Bash
     */

    /**
     * 196-197 SQL
     */

    /**
     * 198. House Robber
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] result = new int[len];
        result[len-1] = nums[len-1];
        result[len-2] = Math.max(nums[len-1], nums[len-2]);

        for (int i = len-3; i >= 0; i--) {
            result[i] = Math.max(result[i+1], result[i+2] + nums[i]);
        }

        return result[0];
    }

    /**
     * 199. Binary Tree Right Side View
     */
    private List<Integer> listFromRight;
    public List<Integer> rightSideView(TreeNode root) {
        listFromRight = new ArrayList<>();
        preOrderTraverse(root, 0);
        return listFromRight;
    }
    private void preOrderTraverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == listFromRight.size()) {
            listFromRight.add(root.val);
        }
        else {
            listFromRight.set(level, root.val);
        }

        preOrderTraverse(root.left, level + 1);
        preOrderTraverse(root.right, level + 1);
    }
}
