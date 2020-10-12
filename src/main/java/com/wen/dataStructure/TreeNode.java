package com.wen.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String result = String.valueOf(val);
        if (left != null || right != null) {
            result += ":: {";
            result += left == null ? "" : " left:[" + left + "]";
            result += right == null ? "" : " right:[" + right + "]";
            result += "}";
        }
        return result;
    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root;

        if (nodes[0] != null) {
            root = new TreeNode(nodes[0]);
            queue.offer(root);
        }
        else {
            root = null;
        }

        for (int i = 1; i < nodes.length && !queue.isEmpty(); i++) {
            TreeNode currentNode = queue.poll();
            TreeNode left = null, right = null;

            if (nodes[i] != null) {
                left = new TreeNode(nodes[i]);
                queue.offer(left);
            }
            i++;
            if (i < nodes.length && nodes[i] != null) {
                right = new TreeNode(nodes[i]);
                queue.offer(right);
            }

            currentNode.left = left;
            currentNode.right = right;
        }

        return root;
    }
}
