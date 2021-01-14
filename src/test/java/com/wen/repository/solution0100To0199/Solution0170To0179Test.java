package com.wen.repository.solution0100To0199;

import com.wen.util.WenList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution0170To0179Test {

    Solution0170To0179 solution = new Solution0170To0179();

    @Test
    public void calculateMinimumHP() {
        List<List<Integer>> list = WenList.getListFromString("[[-2,-3,3],[-5,-10,1],[10,30,-5]]");
        int[][] dungeon = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                dungeon[i][j] = list.get(i).get(j);
            }
        }

        System.out.println(solution.calculateMinimumHP(dungeon));
    }

    @Test
    public void largestNumber() {
        System.out.println(solution.largestNumber(new int[]{10,2}));
    }
}