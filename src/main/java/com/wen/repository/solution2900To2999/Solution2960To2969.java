package com.wen.repository.solution2900To2999;

import java.util.HashSet;
import java.util.Set;

public class Solution2960To2969 {
  /**
   * 2960. Count Tested Devices After Test Operations
   *
   * <p>1 <= n == batteryPercentages.length <= 100</p>
   * <p>0 <= batteryPercentages[i] <= 100</p>
   */
  public int countTestedDevices(int[] batteryPercentages) {
    int count = 0;
    for (int batteryPercentage : batteryPercentages) {
      if (batteryPercentage > count) {
        count++;
      }
    }
    return count;
  }

  /**
   * 2965. Find Missing and Repeated Values
   *
   * <p>2 <= n == grid.length == grid[i].length <= 50</p>
   * <p>1 <= grid[i][j] <= n * n</p>
   * <p>For all x that 1 <= x <= n * n there is exactly one x that is not equal to any of the grid members.</p>
   * <p>For all x that 1 <= x <= n * n there is exactly one x that is equal to exactly two of the grid members.</p>
   * <p>For all x that 1 <= x <= n * n except two of them there is exatly one pair of i, j that 0 <= i, j <= n - 1
   * and grid[i][j] == x.</p>
   */
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    int sum = (1 + n * n) * n * n / 2;
    Set<Integer> set = new HashSet<>();
    int repeat = 0;
    for (int[] array : grid) {
      for (int num : array) {
        if (set.contains(num)) {
          repeat = num;
        } else {
          set.add(num);
        }
        sum -= num;
      }
    }
    int missing = sum + repeat;
    return new int[]{repeat, missing};
  }
}
