package com.wen.repository.solution0400To0499;

public class Solution0430To0439 {

    /**
     * 463. Island Perimeter
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i-1][j] == 0) {
                        count++;
                    }
                    if (j == 0 || grid[i][j-1] == 0) {
                        count++;
                    }
                    if (i == m - 1 || grid[i+1][j] == 0) {
                        count++;
                    }
                    if (j == n - 1 || grid[i][j+1] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
