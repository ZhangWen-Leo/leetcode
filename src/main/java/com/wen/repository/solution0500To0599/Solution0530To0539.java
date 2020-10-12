package com.wen.repository.solution0500To0599;

import com.wen.dataStructure.TreeNode;

import java.util.Stack;

public class Solution0530To0539 {

    /**
     * 530. Minimum Absolute Difference in BST
     */
    public int getMinimumDifference(TreeNode root) {
        TreeNode current, next;
        Stack<TreeNode> stack = new Stack<>();

        // 确定初始current
        current = root;
        while (current.left != null) {
            stack.push(current);
            current = current.left;
        }

        // 确定初始next
        if (current.right != null) {
            next = current.right;
            while (next.left != null) {
                stack.push(next);
                next = next.left;
            }
        }
        else {
            next = stack.pop();
        }

        // 开始遍历
        int min = Integer.MAX_VALUE;
        while (next != null) {
            min = Integer.min(min, next.val - current.val);

            current = next;
            if (current.right != null) {
                next = current.right;
                while (next.left != null) {
                    stack.push(next);
                    next = next.left;
                }
            }
            else if (!stack.isEmpty()) {
                next = stack.pop();
            }
            else {
                next = null;
            }
        }

        return min;
    }

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
