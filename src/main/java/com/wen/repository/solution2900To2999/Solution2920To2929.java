package com.wen.repository.solution2900To2999;

public class Solution2920To2929 {
  /**
   * 2924. Find Champion II
   *
   * <p>1 <= n <= 100</p>
   * <p>m == edges.length</p>
   * <p>0 <= m <= n * (n - 1) / 2</p>
   * <p>edges[i].length == 2</p>
   * <p>0 <= edge[i][j] <= n - 1</p>
   * <p>edges[i][0] != edges[i][1]</p>
   * <p>The input is generated such that if team a is stronger than team b, team b is not stronger than team a.</p>
   * <p>The input is generated such that if team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.</p>
   */
  public int findChampion(int n, int[][] edges) {
    boolean[] betterThan = new boolean[n];
    int count = n;
    for (int[] edge : edges) {
      int worse = edge[1];

      if (!betterThan[worse]) {
        betterThan[worse] = true;
        count--;
      }
    }

    if (count > 1) {
      return -1;
    } else if (count == 1) {
      for (int i = 0; i < n; i++) {
        if (!betterThan[i]) {
          return i;
        }
      }
      throw new Error("计数不对");
    } else {
      throw new Error("存在环");
    }
  }
}
