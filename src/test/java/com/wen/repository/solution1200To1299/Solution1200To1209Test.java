package com.wen.repository.solution1200To1299;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution1200To1209Test {

    Solution1200To1209 solution = new Solution1200To1209();

    @Test
    public void smallestStringWithSwaps() {
        String s = "dcab";
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(list1);
        pairs.add(list2);
        pairs.add(list3);
        System.out.println(solution.smallestStringWithSwaps(s, pairs));
    }
}