package com.wen.repository.solution0900To0999;

import com.wen.dataStructure.TreeNode;

public class Solution0960To0969 {
    /**
     * 968. 监控二叉树
     */
    private int count;
    public int minCameraCover(TreeNode root) {
        count = 0;
        if (!behindOrder(root)[1]) {
            count++;
        }
        return count;
    }
    private boolean[] behindOrder(TreeNode root) {
        if (root == null) {
            return new boolean[]{false, true};
        }

        boolean[] leftHasMonitor = behindOrder(root.left);
        boolean[] rightHasMonitor = behindOrder(root.right);

        if (!leftHasMonitor[1] || !rightHasMonitor[1]) {
            count++;
            return new boolean[]{true, true};
        }
        else if (leftHasMonitor[0] || rightHasMonitor[0]) {
            return new boolean[]{false, true};
        }
        else {
            return new boolean[]{false, false};
        }
    }
}
