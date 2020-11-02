package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0190To0199 {

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
