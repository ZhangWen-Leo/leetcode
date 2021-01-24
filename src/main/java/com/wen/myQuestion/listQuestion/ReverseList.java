package com.wen.myQuestion.listQuestion;

import com.wen.dataStructure.ListNode;

/**
 * 翻转链表
 */
public class ReverseList {

    /**
     * 递归实现
     */
    public static ListNode reverseByRecursion(ListNode head) {
        return reverseByRecursionSup(head)[0];
    }
    private static ListNode[] reverseByRecursionSup(ListNode current) {
        if (current == null) {
            return new ListNode[]{null, null};
        }

        if (current.next == null) {
            return new ListNode[]{current, current};
        }
        else {
            ListNode[] followList = reverseByRecursionSup(current.next);
            followList[1].next = current;
            followList[1] = current;
            current.next = null;
            return followList;
        }
    }

    /**
     * 遍历实现
     */
    public static ListNode reverseByTraverse(ListNode head) {
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
}
