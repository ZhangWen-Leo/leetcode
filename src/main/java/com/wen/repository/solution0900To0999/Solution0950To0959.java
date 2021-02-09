package com.wen.repository.solution0900To0999;

public class Solution0950To0959 {

    /**
     * 959. Regions Cut By Slashes
     */
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        boolean[][] matrix = new boolean[len][len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!matrix[i][j] && grid[i].charAt(j) != '/')
            }
        }
    }
}
