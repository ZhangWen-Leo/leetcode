package com.wen.explore.topInterviewQuestionsMedium;

import com.wen.dataStructure.Node;
import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeOrGraph {
    /**
     * 二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }

    /**
     * 二叉树的锯齿形层次遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        else {
            normalLevelOrder(root, lists, 0);
        }

        for (int i = 0; i < lists.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(lists.get(i));
            }
        }
        return lists;
    }
    private void normalLevelOrder(TreeNode root, List<List<Integer>> lists, int level) {
        while (level >= lists.size()) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }

        lists.get(level).add(root.val);
        if (root.left != null) {
            normalLevelOrder(root.left, lists, level+1);
        }
        if (root.right != null) {
            normalLevelOrder(root.right, lists, level+1);
        }
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;

        if (preorder.length > 0) {
            root = new TreeNode(preorder[0]);
            int a = indexOf(inorder, preorder[0]);
            if (a < 0) {
                System.out.println("列表不符合要求");
            }
            else {
                root.left = buildTree(
                        Arrays.copyOfRange(preorder, 1, a+1),
                        Arrays.copyOfRange(inorder, 0, a)
                );
                root.right = buildTree(
                        Arrays.copyOfRange(preorder, a+1, preorder.length),
                        Arrays.copyOfRange(inorder, a+1, inorder.length)
                );
            }
        }

        return root;
    }
    private int indexOf(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     * 见116
     */

    /**
     * 二叉搜索树中第K小的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        int last = -1;

        TreeNode p = root;
        while (p != null) {
            list.add(0, p);
            p = p.left;
        }
        last = 0;

        while (last < k-1) {
            p = list.get(last).right;
            if (p != null) {
                while (p != null) {
                    list.add(last+1, p);
                    p = p.left;
                }
            }
            last++;
        }
        return list.get(k-1).val;
    }

    /**
     * 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0) {
            return result;
        }
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!checked[i][j] && grid[i][j] == '1') {
                    result++;
                    myNumIslands(grid, checked, i, j);
                }
            }
        }

        return result;
    }
    private void myNumIslands(char[][] grid, boolean[][] checked, int i, int j) {
        checked[i][j] = true;
        if (i > 0) {
            if (!checked[i-1][j] && grid[i-1][j] == '1') {
                myNumIslands(grid, checked, i-1, j);
            }
            else {
                checked[i-1][j] = true;
            }
        }
        if (j > 0) {
            if (!checked[i][j-1] && grid[i][j-1] == '1') {
                myNumIslands(grid, checked, i, j-1);
            }
            else {
                checked[i][j-1] = true;
            }
        }
        if (i < grid.length-1) {
            if (!checked[i+1][j] && grid[i+1][j] == '1') {
                myNumIslands(grid, checked, i+1, j);
            }
            else {
                checked[i+1][j] = true;
            }
        }
        if (j < grid[0].length-1) {
            if (!checked[i][j+1] && grid[i][j+1] == '1') {
                myNumIslands(grid, checked, i, j+1);
            }
            else {
                checked[i][j+1] = true;
            }
        }
    }
}
