package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0140To0149 {

    /**
     * 145. Binary Tree Postorder Traversal
     */
    List<Integer> postorderList;
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderList = new ArrayList<>();
        postOrderTraversal(root);
        return postorderList;
    }
    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            postorderList.add(root.val);
        }
    }
}
