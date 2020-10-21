package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution0020To0029 {

    /**
     * 23. Merge k Sorted Lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head, tail, p;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        head = queue.poll();
        tail = head;
        if (head.next != null) {
            queue.offer(head.next);
        }

        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p.next != null) {
                queue.offer(p.next);
            }
            tail.next = p;
            tail = tail.next;
        }

        tail.next = null;
        return head;
    }

    /**
     * 24. Swap Nodes in Pairs
     */
    public ListNode swapPairs(ListNode head) {
        ListNode p1, p2, p3, result;

        p2 = head;
        if (p2 != null) {
            p3 = p2.next;
        }
        else {
            return null;
        }
        if (p3 != null) {
            p2.next = p3.next;
            p3.next = p2;
        }
        else {
            return p2;
        }

        result = p3;
        p1 = p2;
        while (true) {
            p2 = p1.next;
            if (p2 != null) {
                p3 = p2.next;
            }
            else {
                break;
            }
            if (p3 == null) {
                break;
            }

            p2.next = p3.next;
            p1.next = p3;
            p3.next = p2;
            p1 = p2;
        }

        return result;
    }

    /**
     * 25. Reverse Nodes in k-Group
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode tail;

        tail = head;
        int i = 0;
        while (i < k && tail != null) {
            tail = tail.next;
            i++;
        }
        if (i < k) {
            return head;
        }

        ListNode currentHead, currentTail, p, q;
        currentHead = head;
        currentTail = head;
        p = currentTail.next;
        currentTail.next = null;

        while (p != tail) {
            q = p.next;
            p.next = currentHead;
            currentHead = p;
            p = q;
        }

        currentTail.next = reverseKGroup(tail, k);

        return currentHead;
    }
}
