package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0020To0029Test {

    Solution0020To0029 solution = new Solution0020To0029();

    @Test
    public void mergeKLists() {
        ListNode[] lists = {
                ListNode.createList(new int[]{1,4,5}),
                ListNode.createList(new int[]{1,3,4}),
                ListNode.createList(new int[]{2,6})
        };

        System.out.println(solution.mergeKLists(lists));
    }
}