package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

import java.util.Arrays;

public class Solution0080To0089 {

    /**
     * 80. Remove Duplicates from Sorted Array II
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int indexA, indexB, indexC;
        boolean twice = false;
        indexA = 0;
        indexB = 1;
        indexC = 1;

        while (indexC < nums.length) {
            if (nums[indexC] == nums[indexA]) {
                if (!twice) {
                    twice = true;
                    nums[indexB++] = nums[indexC];
                }
            }
            else {
                twice = false;
                indexA = indexB;
                nums[indexB++] = nums[indexC];
            }
            indexC++;
        }
        return indexB;
    }

    /**
     * 81. Search in Rotated Sorted Array II
     */
    // 2ms
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }
    private boolean search(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return false;
        }
        if (end - 1 == start || nums[end - 1] > nums[start]) {
            return Arrays.binarySearch(nums, start, end, target) >= 0;
        }

        int mid = (start + end) / 2;
        if (target > nums[start]) {
            if (target < nums[mid]) {
                return Arrays.binarySearch(nums, start, mid, target) >= 0;
            }
            else if (target == nums[mid]) {
                return true;
            }
            else {
                return search(nums, target, start, mid) || search(nums, target, mid, end);
            }
        }
        else if (target == nums[start]) {
            return true;
        }
        else if (target > nums[end - 1]) {
            return false;
        }
        else if (target == nums[end - 1]) {
            return true;
        }
        else {
            if (target > nums[mid]) {
                return Arrays.binarySearch(nums, mid, end, target) >= 0;
            }
            else if (target == nums[mid]) {
                return true;
            }
            else {
                return search(nums, target, start, mid) || search(nums, target, mid, end);
            }
        }
    }
    // 1ms
//    public boolean search(int[] nums, int target) {
//        if (nums.length == 0) {
//            return false;
//        }
//        if (target > nums[0]) {
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] == target) {
//                    return true;
//                }
//                else if (nums[i] > target || nums[i] < nums[0]) {
//                    return false;
//                }
//            }
//            return false;
//        }
//        else if (target == nums[0]) {
//            return true;
//        }
//        else if (target > nums[nums.length - 1]) {
//            return false;
//        }
//        else if (target == nums[nums.length - 1]) {
//            return true;
//        }
//        else {
//            for (int i = nums.length - 2; i >= 0; i--) {
//                if (nums[i] == target) {
//                    return true;
//                }
//                else if (nums[i] < target || nums[i] > nums[nums.length - 1]) {
//                    return false;
//                }
//            }
//            return false;
//        }
//    }

    /**
     * 82. Remove Duplicates from Sorted List II
     */
    public ListNode deleteDuplicates82(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head.next;

        if (node != null && node.val == head.val) {
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            return deleteDuplicates82(node);
        }
        else {
            head.next = deleteDuplicates82(node);
            return head;
        }
    }

    /**
     * 83. Remove Duplicates from Sorted List
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nodeA, nodeB;
        nodeA = head;
        nodeB = nodeA;
        while (nodeB != null) {
            while (nodeB != null && nodeB.val == nodeA.val) {
                nodeB = nodeB.next;
            }
            nodeA.next = nodeB;
            nodeA = nodeB;
        }
        return head;
    }
}
