package com.wen.repository.solution0500To0599;

import com.wen.dataStructure.TreeNode;

public class Solution0530To0539 {
    /**
     * 538. 把二叉搜索树转换为累加树
     */
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        rightFirstInOrder(root);
        return root;
    }
    private void rightFirstInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        rightFirstInOrder(root.right);
        root.val += sum;
        sum = root.val;
        rightFirstInOrder(root.left);
    }
}
