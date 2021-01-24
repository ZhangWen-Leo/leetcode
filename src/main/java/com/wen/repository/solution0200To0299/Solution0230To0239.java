package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;
import com.wen.myQuestion.listQuestion.ReverseList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Solution0230To0239 {

    /**
     * 233. Number of Digit One
     */
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        int length = 2, x = n / 100;
        while (x > 0) {
            x /= 10;
            length++;
        }

        int[] pre = new int[length - 1];
        pre[0] = 1;

        for (int i = 1; i < length - 1; i++) {
            pre[i] = (int) Math.pow(10, i);
            pre[i] += 10 * pre[i-1];
        }

        int result = 0;

        int a = n / (int) Math.pow(10, length - 1);
        int b = n % (int) Math.pow(10, length - 1);

        if (a > 1) {
            result += (int) Math.pow(10, length - 1);
        }
        else {
            result += b + 1;
        }
        result += a * pre[length - 2];
        result += countDigitOne(b);

        return result;
    }

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
        return ReverseList.reverseByRecursion(head);
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

    /**
     * 239. Sliding Window Maximum
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0, end = k;
        int[] result = new int[nums.length - k + 1];
        LinkedList<int[]> goDown = new LinkedList<>();

        for (int i = start; i < end-1; i++) {
            while (!goDown.isEmpty() && goDown.getLast()[0] < nums[i]) {
                goDown.removeLast();
            }
            goDown.offer(new int[]{nums[i], i});
        }
        while (end <= nums.length) {
            while (!goDown.isEmpty() && goDown.getLast()[0] < nums[end-1]) {
                goDown.removeLast();
            }
            goDown.offer(new int[]{nums[end-1], end-1});

            result[start] = goDown.get(0)[0];

            if (goDown.get(0)[1] == start) {
                goDown.removeFirst();
            }
            start++;
            end++;
        }

        return result;
    }
}
