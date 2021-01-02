package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0140To0149Test {

    Solution0140To0149 solution = new Solution0140To0149();

    @Test
    public void hasCycle() {
        System.out.println(solution.hasCycle(ListNode.createList(
                new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5}
        )));
    }

    @Test
    public void maxPoints() {
        int[][] points = {
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        System.out.println(solution.maxPoints(points));
    }
}