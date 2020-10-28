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

    /**
     * 97. Interleaving String
     */
    private int[][] checkMatrix;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        checkMatrix = new int[s1.length()+1][s2.length()+1];
        return isInterleave(s1, s2, s3, s1.length(), s2.length(), s3.length());
    }
    private boolean isInterleave(String s1, String s2, String s3, int end1, int end2, int end3) {
        if (checkMatrix[end1][end2] > 0) {
            return checkMatrix[end1][end2] == 1;
        }
        if (end3 == 0) {
            if (end1 == 0 && end2 == 0) {
                checkMatrix[end1][end2] = 1;
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }
        else if (end1 == 0 || end2 == 0) {
            if (s3.substring(0, end3).equals(end1 == 0 ? s2.substring(0, end2) : s1.substring(0, end1))) {
                checkMatrix[end1][end2] = 1;
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }
        else {
            char c1 = s1.charAt(end1 - 1);
            char c2 = s2.charAt(end2 - 1);
            char c = s3.charAt(end3 - 1);

            if (c == c1 && c == c2) {
                if (isInterleave(s1, s2, s3, end1 - 1, end2, end3 - 1)
                        || isInterleave(s1, s2, s3, end1, end2 - 1, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else if (c == c1) {
                if (isInterleave(s1, s2, s3, end1 - 1, end2, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else if (c == c2) {
                if (isInterleave(s1, s2, s3, end1, end2 - 1, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }

        return checkMatrix[end1][end2] == 1;
    }
}
