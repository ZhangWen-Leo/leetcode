package com.wen.repository.solution0600To0699;

import com.wen.dataStructure.TreeNode;

public class Solution0610To0619 {
    /**
     * 617. 合并二叉树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }
}
