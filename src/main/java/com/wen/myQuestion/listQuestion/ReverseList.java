package com.wen.myQuestion.listQuestion;

import com.wen.dataStructure.ListNode;

/**
 * 翻转链表
 */
public class ReverseList {

    /**
     * 递归实现
     */
    public ListNode reverseByRecursion(ListNode head) {
        return reverseByRecursionSup(head)[0];
    }
    private ListNode[] reverseByRecursionSup(ListNode current) {
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
}
