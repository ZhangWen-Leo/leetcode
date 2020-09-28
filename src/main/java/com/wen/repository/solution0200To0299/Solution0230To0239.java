package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.TreeNode;

import java.util.Stack;

public class Solution0230To0239 {

    /**
     * 235. 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> checkStack = new Stack<>();
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        boolean hasFoundP = false, hasFoundQ = false;
        TreeNode result = null;

        if (root != null) {
            stack.push(root);
            checkStack.push(0);

            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.peek();
                int currentCheck = checkStack.peek();
                if (currentNode == p) {
                    hasFoundP = true;
                    stackP.addAll(stack);
                }
                if (currentNode == q) {
                    hasFoundQ = true;
                    stackQ.addAll(stack);
                }
                if (hasFoundP && hasFoundQ) {
                    break;
                }

                if (currentCheck == 0) {
                    checkStack.pop();
                    checkStack.push(1);
                    if (currentNode.left != null) {
                        stack.push(currentNode.left);
                        checkStack.push(0);
                    }
                    else {
                        currentCheck = 1;
                    }
                }
                if (currentCheck == 1) {
                    checkStack.pop();
                    checkStack.push(2);
                    if (currentNode.right != null) {
                        stack.push(currentNode.right);
                        checkStack.push(0);
                    }
                    else {
                        currentCheck = 2;
                    }
                }
                if (currentCheck == 2) {
                    stack.pop();
                    checkStack.pop();
                }
            }

            while (!stackP.isEmpty()) {
                TreeNode currentNode = stackP.pop();
                if (stackQ.search(currentNode) >= 0) {
                    result = currentNode;
                    break;
                }
            }
        }

        return result;
    }
}
