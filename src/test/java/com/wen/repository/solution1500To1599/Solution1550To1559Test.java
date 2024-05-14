package com.wen.repository.solution1500To1599;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1550To1559Test {

    Solution1550To1559 solution = new Solution1550To1559();

    @Test
    public void minDays() {
        int i = 1;
        System.out.println(i);
        System.out.println(solution.minDays(i));
    }

    @Test
    public void findSmallestSetOfVertices() {
        List<Integer> result = solution.findSmallestSetOfVertices(1, new ArrayList<>());
        System.out.println(result.getFirst());
    }
}
