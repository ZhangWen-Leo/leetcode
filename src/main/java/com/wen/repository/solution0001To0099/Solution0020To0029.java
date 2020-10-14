package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

public class Solution0020To0029 {

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
}
