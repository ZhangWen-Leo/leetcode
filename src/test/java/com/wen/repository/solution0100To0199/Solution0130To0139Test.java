package com.wen.repository.solution0100To0199;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution0130To0139Test {

    Solution0130To0139 solution = new Solution0130To0139();

    @Test
    public void solve() {
        char[][] board = {
                {'O', 'X', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'X'}
        };
        solution.solve(board);
    }

    @Test
    public void partition() {
        String s = "aab";
        System.out.println(solution.partition(s));
    }

    @Test
    public void candy() {
        int[] ratings = {
                1,3,2,2,1
        };
        System.out.println(solution.candy(ratings));
    }

    @Test
    public void canCompleteCircuit() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    @Test
    public void wordBreak() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(solution.wordBreak(s, wordDict));
    }
}