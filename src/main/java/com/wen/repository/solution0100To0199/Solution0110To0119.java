package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.Node;
import com.wen.dataStructure.TreeNode;

import java.util.*;

public class Solution0110To0119 {

    /**
     * 110. Balanced Binary Tree
     */
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelp(root) >= 0;
    }
    private int isBalancedHelp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedHelp(root.left),
                right = isBalancedHelp(root.right);

        if (left < 0 || right < 0) {
            return -1;
        }
        else if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        else {
            return -1;
        }
    }

    /**
     * 111. Minimum Depth of Binary Tree
     *
     * 解法2
     *
     * 1ms 82%
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            depth++;
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                else {
                    if (node.left != null) {
                        queue2.offer(node.left);
                    }
                    if (node.right != null) {
                        queue2.offer(node.right);
                    }
                }
            }
            depth++;
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                else {
                    if (node.left != null) {
                        queue1.offer(node.left);
                    }
                    if (node.right != null) {
                        queue1.offer(node.right);
                    }
                }
            }
        }

        return depth;
    }
    /**
     * 解法1
     *
     * 8ms  29.24%
     */
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//
//        int depth = Integer.MAX_VALUE;
//        if (root.left != null) {
//            depth = Math.min(depth, minDepth(root.left) + 1);
//        }
//        if (root.right != null) {
//            depth = Math.min(depth, minDepth(root.right) + 1);
//        }
//
//        return depth;
//    }

    /**
     * 112. Path Sum
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    /**
     * 113. 路径总和 II
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root != null) {
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    lists.add(list);
                }
            }
            else {
                List<List<Integer>> subLists;
                // 左子树
                subLists = pathSum(root.left, sum - root.val);
                for (List<Integer> subList :
                        subLists) {
                    subList.add(0, root.val);
                    lists.add(subList);
                }
                // 右子树
                subLists = pathSum(root.right, sum - root.val);
                for (List<Integer> subList :
                        subLists) {
                    subList.add(0, root.val);
                    lists.add(subList);
                }
            }
        }

        return lists;
    }

    /**
     * 114. Flatten Binary Tree to Linked List
     */
    public void flatten(TreeNode root) {
        flattenHelp(root);
    }
    private TreeNode[] flattenHelp(TreeNode root) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        if (root.left == null && root.right == null) {
            return new TreeNode[]{root, root};
        }
        else if (root.left != null && root.right != null) {
            TreeNode[] newLeft = flattenHelp(root.left);
            TreeNode[] newRight = flattenHelp(root.right);

            root.left = null;
            root.right = newLeft[0];
            newLeft[1].right = newRight[0];
            return new TreeNode[]{root, newRight[1]};
        }
        else if (root.left != null) {
            TreeNode[] newLeft = flattenHelp(root.left);

            root.left = null;
            root.right = newLeft[0];
            return new TreeNode[]{root, newLeft[1]};
        }
        else {
            TreeNode[] newRight = flattenHelp(root.right);

            return new TreeNode[]{root, newRight[1]};
        }
    }

    /**
     * 115. Distinct Subsequences
     */
    private int[][] numDistinctDp;
    public int numDistinct(String s, String t) {
        numDistinctDp = new int[s.length()+1][t.length()+1];
        for (int[] list :
                numDistinctDp) {
            Arrays.fill(list, -1);
        }
        return numDistinct(s, 0, t, 0);
    }
    private int numDistinct(String s, int start1, String t, int start2) {
        if (numDistinctDp[start1][start2] >= 0) {
            return numDistinctDp[start1][start2];
        }
        int length1 = s.length() - start1, length2 = t.length() - start2;
        if (length1 < length2) {
            numDistinctDp[start1][start2] = 0;
            return numDistinctDp[start1][start2];
        }
        if (length2 == 0) {
            numDistinctDp[start1][start2] = 1;
            return numDistinctDp[start1][start2];
        }

        numDistinctDp[start1][start2] = 0;
        for (int i = start1; i <= s.length() - length2; i++) {
            if (s.charAt(i) == t.charAt(start2)) {
                numDistinctDp[start1][start2] += numDistinct(s, i+1, t, start2+1);
            }
        }
        return numDistinctDp[start1][start2];
    }


    /**
     * 116. Populating Next Right Pointers in Each Node
     */
    public Node connectFor116(Node root) {
        List<Node> list = new ArrayList<>();

        normalInOrderTraverse(root, list, 0);

        return root;
    }
    private void normalInOrderTraverse(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            Node last = root;
            list.add(last);
        }
        else {
            list.get(level).next = root;
            list.set(level, root);
        }

        normalInOrderTraverse(root.left, list, level+1);
        normalInOrderTraverse(root.right, list, level+1);

        return;
    }

    /**
     * 117. Populating Next Right Pointers in Each Node II
     */
    private List<Node> endNodeInEachLevel;
    public Node connect(Node root) {
        endNodeInEachLevel = new ArrayList<>();
        myConnect(root, 0);
        return root;
    }
    private void myConnect(Node root, int level) {
        if (root != null) {
            while (endNodeInEachLevel.size() <= level) {
                endNodeInEachLevel.add(null);
            }
            if (endNodeInEachLevel.get(level) != null) {
                endNodeInEachLevel.get(level).next = root;
            }
            endNodeInEachLevel.set(level, root);
            myConnect(root.left, level+1);
            myConnect(root.right, level+1);
        }
    }
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 118. Pascal's Triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if (numRows == 1) {
            return result;
        }

        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            List<Integer> lastRow = result.get(i-1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(lastRow.get(j-1) + lastRow.get(j));
            }
            list.add(1);
            result.add(list);
        }

        return result;
    }

    /**
     * 119. Pascal's Triangle II
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        if (rowIndex == 0) {
            return result;
        }

        int i = 0;
        while (i < rowIndex) {
            int left = 0, right;
            int size = result.size();
            for (int j = 0; j < size; j++) {
                right = result.get(j);
                result.set(j, left + right);
                left = right;
            }
            result.add(1);
            i++;
        }

        return result;
    }
}