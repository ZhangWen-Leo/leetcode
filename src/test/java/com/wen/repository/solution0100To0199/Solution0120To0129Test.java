package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution0120To0129Test {

    Solution0120To0129 solution = new Solution0120To0129();

    @Test
    public void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(solution.minimumTotal(triangle));
    }

    @Test
    public void maxProfit() {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};

        System.out.println(solution.maxProfit(prices));
    }

    @Test
    public void maxPathSum() {
        System.out.println(solution.maxPathSum(TreeNode.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1})));
    }

    @Test
    public void ladderLength() {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(solution.ladderLength(begin, end, wordList));
    }
}