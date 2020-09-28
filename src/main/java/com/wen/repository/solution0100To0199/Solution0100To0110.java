package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0100To0110 {

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> in = new ArrayList<>(inorder.length);
        List<Integer> post = new ArrayList<>(postorder.length);
        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
            post.add(postorder[i]);
        }
        return myBuildTree(in, post);
    }
    private TreeNode myBuildTree(List<Integer> inorder, List<Integer> postorder) {
        int length = inorder.size();

        if (length == 0) {
            return null;
        }
        else if (length == 1) {
            TreeNode root = new TreeNode(inorder.get(0));
            return root;
        }

        TreeNode root = new TreeNode(postorder.get(length-1));
        int rootIndex = inorder.indexOf(root.val);
        root.left = myBuildTree(inorder.subList(0, rootIndex), postorder.subList(0, rootIndex));
        root.right = rootIndex == length-1 ? null :
                myBuildTree(inorder.subList(rootIndex+1, length), postorder.subList(rootIndex, length-1));
        return root;
    }

    /**
     * 107. 二叉树的层次遍历 II
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        myLevelOrderBottom(root, lists, 0);

        return lists;
    }
    private void myLevelOrderBottom(TreeNode root, List<List<Integer>> lists, int level) {
        if (root == null) {
            return;
        }

        while (level >= lists.size()) {
            List<Integer> list = new ArrayList<>();
            lists.add(0, list);
        }

        lists.get(lists.size()-level-1).add(root.val);
        myLevelOrderBottom(root.left, lists, level+1);
        myLevelOrderBottom(root.right, lists, level+1);
    }
}
