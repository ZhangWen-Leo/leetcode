package com.wen.repository.solution0100To0199.design;

import com.wen.dataStructure.TreeNode;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public int next() {
        TreeNode p = stack.pop();
        if (p.right != null) {
            TreeNode q = p.right;
            while (q != null) {
                stack.push(q);
                q = q.left;
            }
        }
        return p.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
