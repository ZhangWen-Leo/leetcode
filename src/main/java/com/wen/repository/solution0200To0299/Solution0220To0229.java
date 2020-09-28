package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.TreeNode;

public class Solution0220To0229 {
    /**
     * 226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
