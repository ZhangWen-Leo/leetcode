package com.wen.repository.solution2600To2699;

public class Solution2680To2689 {
  /**
   * 2684. Maximum Number of Moves in a Grid
   *
   * <p>m == grid.length</p>
   * <p>n == grid[i].length</p>
   * <p>2 <= m, n <= 1000</p>
   * <p>4 <= m * n <= 10^5</p>
   * <p>1 <= grid[i][j] <= 10^6</p>
   */
  public int maxMoves(int[][] grid) {
    int rowLength = grid.length, colLength = grid[0].length;
    int[][] count = new int[rowLength][colLength];
    int maxMove = 0;
    for (int i = colLength - 2; i >= 0; i--) {
      for (int j = 0; j < rowLength; j++) {
        int max = grid[j][i] < grid[j][i + 1] ? count[j][i + 1] : -1;
        if (j > 0 && grid[j][i] < grid[j - 1][i + 1]) {
          max = Math.max(max, count[j - 1][i + 1]);
        }
        if (j < rowLength - 1 && grid[j][i] < grid[j + 1][i + 1]) {
          max = Math.max(max, count[j + 1][i + 1]);
        }
        count[j][i] = max + 1;
        if (i == 0) {
          maxMove = Math.max(maxMove, count[j][i]);
        }
      }
    }

    return maxMove;
  }
}
