package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution0100To0110 {

    /**
     * 100. Same Tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if ((p != null && q != null)
                && p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 101. Symmetric Tree
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        else {
            return isSymmetric(root.left, root.right);
        }
    }
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if ((p != null && q != null)
                && p.val == q.val
                && isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 102. Binary Tree Level Order Traversal
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preOrderTraversal(root, 1, result);
        return result;
    }
    private void preOrderTraversal(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        while (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level-1).add(node.val);
        preOrderTraversal(node.left, level+1, result);
        preOrderTraversal(node.right, level+1, result);
        return;
    }

    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            list = new ArrayList<>();
            while (!stackA.isEmpty()) {
                TreeNode node = stackA.pop();
                if (node.right != null) {
                    list.add(node.right.val);
                    stackB.push(node.right);
                }
                if (node.left != null) {
                    list.add(node.left.val);
                    stackB.push(node.left);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
            list = new ArrayList<>();
            while (!stackB.isEmpty()) {
                TreeNode node = stackB.pop();
                if (node.left != null) {
                    list.add(node.left.val);
                    stackA.push(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    stackA.push(node.right);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }

        return result;
    }

    /**
     * 104. Maximum Depth of Binary Tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        return buildTree(preorder, 0, length, inorder, 0, length);
    }
    private TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 >= end1) {
            return null;
        }

        int i = start2;
        while (i < end2) {
            if (inorder[i] == preorder[start1]) {
                break;
            }
            i++;
        }
        if (i < end2) {
            TreeNode node = new TreeNode(preorder[start1]);
            node.left = buildTree(preorder, start1+1, start1+1+(i-start2), inorder, start2, i);
            node.right = buildTree(preorder, start1+1+(i-start2), end1, inorder, i+1, end2);
            return node;
        }
        else {
            System.out.println("参数错误");
            return null;
        }
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     */
    public TreeNode buildTree106(int[] inorder, int[] postorder) {
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

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, start, middle);
        node.right = sortedArrayToBST(nums, middle+1, end);
        return node;
    }

    /**
     * 109. Convert Sorted List to Binary Search Tree
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head, slow = head, tail = slow;

        while (true) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            tail = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }
        tail.next = null;
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
    }
}
