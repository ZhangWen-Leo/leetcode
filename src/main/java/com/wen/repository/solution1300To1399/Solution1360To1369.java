package com.wen.repository.solution1300To1399;

import com.wen.dataStructure.ListNode;

public class Solution1360To1369 {

    /**
     * 1365. How Many Numbers Are Smaller Than the Current Number
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        ListNode head = new ListNode(-1);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ListNode node = insertList(nums, i, head);
            for (ListNode p = head.next; p != null && nums[p.val] < nums[node.val]; p = p.next) {
                result[node.val]++;
            }
            for (ListNode p = node.next; p != null; p = p.next) {
                result[p.val]++;
            }
        }

        return result;
    }
    private ListNode insertList(int[] nums, int index, ListNode head) {
        ListNode node = new ListNode(index);

        ListNode p = head;
        while (p.next != null && nums[node.val] >= nums[p.next.val]) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;

        return node;
    }
}
