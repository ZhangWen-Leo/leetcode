package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;

import java.util.Stack;

public class Solution0230To0239 {

    /**
     * 234. Palindrome Linked List
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int length = 0;
        ListNode head2, p, q;

        p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < length / 2 - 1; i++) {
            p = p.next;
        }
        if (length % 2 == 1) {
            head2 = p.next.next;
        }
        else {
            head2 = p.next;
        }
        p.next = null;
        head2 = reverseList(head2);

        p = head;
        q = head2;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next, q = head.next.next;
        head.next = null;
        while (q != null) {
            p.next = head;
            head = p;
            p = q;
            q = q.next;
        }
        p.next = head;
        head = p;
        return head;
    }

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
