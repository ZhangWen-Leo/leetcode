package com.wen.repository.solution0001To0099;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution0030To0039Test {

    private Solution0030To0039 solution = new Solution0030To0039();

    @Test
    public void combinationSum() {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        System.out.println(solution.combinationSum(a, target));
    }

    @Test
    public void longestValidParentheses() {
        String s = "(()(((()";
        System.out.println(solution.longestValidParentheses(s));
    }

    @Test
    public void solveSudoku() {
        String[][] a = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = a[i][j].charAt(0);
            }
        }
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}