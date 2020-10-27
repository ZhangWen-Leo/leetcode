package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

public class Solution0090To0099 {

    /**
     * 92. Reverse Linked List II
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode nodeA, nodeB, nodeC, nodeD;
        nodeA = new ListNode(-1);
        nodeA.next = head;

        nodeB = nodeA;
        int i = 1;
        while (i < m) {
            nodeB = nodeB.next;
            i++;
        }

        nodeC = nodeB.next;
        while (i++ < n) {
            nodeC = nodeC.next;
        }
        nodeD = nodeC.next;
        nodeC.next = null;

        ListNode[] reverse = reverseList(nodeB.next);
        nodeB.next = reverse[0];
        reverse[1].next = nodeD;

        return nodeA.next;
    }
    private ListNode[] reverseList(ListNode head) {
        if (head == null) {
            return new ListNode[]{null, null};
        }
        else if (head.next == null) {
            return new ListNode[]{head, head};
        }
        else {
            ListNode[] subList = reverseList(head.next);
            subList[1].next = head;
            subList[1] = head;

            return subList;
        }
    }
}
