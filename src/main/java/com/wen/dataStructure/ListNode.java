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
