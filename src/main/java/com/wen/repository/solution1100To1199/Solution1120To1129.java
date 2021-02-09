package com.wen.repository.solution1100To1199;

public class Solution1120To1129 {

    /**
     * 1128. Number of Equivalent Domino Pairs
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] matrix = new int[9][9];

        int count = 0;
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            count += matrix[a-1][b-1];
            matrix[a-1][b-1]++;
            if (a != b) {
                matrix[b-1][a-1]++;
            }
        }

        return count;
    }
}
