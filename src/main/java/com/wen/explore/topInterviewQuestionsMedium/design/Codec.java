package com.wen.explore.topInterviewQuestionsMedium.design;

import com.wen.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String result = "[" + String.valueOf(root.val);
        queue.offer(root.left);
        queue.offer(root.right);

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                result += ",null";
            }
            else {
                result += "," + String.valueOf(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        result += "]";

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringList = data.substring(1, data.length()-1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        if (stringList[0].equals("") || stringList[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(stringList[0]));
        queue.offer(root);
        int i = 1;
        while (queue.size() > 0 && i < stringList.length) {
            TreeNode node = queue.poll();
            if (stringList[i].equals("null")) {
                node.left = null;
            }
            else {
                TreeNode left = new TreeNode(Integer.valueOf(stringList[i]));
                node.left = left;
                queue.offer(node.left);
            }

            if (++i >= stringList.length) {
                break;
            }
            if (stringList[i].equals("null")) {
                node.right = null;
            }
            else {
                TreeNode right = new TreeNode(Integer.valueOf(stringList[i]));
                node.right = right;
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
