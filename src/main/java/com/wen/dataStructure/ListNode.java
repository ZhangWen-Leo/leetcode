package com.wen.dataStructure;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int count = 100;
        ListNode p = next;

        s.append(val);
        while (count-- > 0 && p != null) {
            s.append(" -> " + p.val);
            p = p.next;
        }
        if (p != null) {
            s.append(" -> ...");
        }

        return s.toString();
    }

    public static ListNode createList(int[] list) {
        if (list.length == 0) {
            return null;
        }
        else {
            ListNode head = null;
            for (int i = list.length-1; i >= 0; i--) {
                ListNode node = new ListNode(list[i], head);
                head = node;
            }
            return head;
        }
    }
}
