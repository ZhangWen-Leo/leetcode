package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0110To0119 {
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
    class Node {
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
}