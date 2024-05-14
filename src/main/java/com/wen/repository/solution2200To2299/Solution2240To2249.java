package com.wen.repository.solution2200To2299;

import java.util.Arrays;

public class Solution2240To2249 {
  /**
   * 2244. Minimum Rounds to Complete All Tasks
   * <p>
   * 1 <= tasks.length <= 10^5 <p>
   * 1 <= tasks[i] <= 10^9
   */
  public int minimumRounds(int[] tasks) {
    Arrays.sort(tasks);
    int cur = Integer.MIN_VALUE;
    int count = 0;
    int res = 0;
    for (int task : tasks) {
      if (cur == task) {
        count++;
      } else {
        if (count == 1) {
          return -1;
        } else {
          res += count / 3 + (count % 3 > 0 ? 1 : 0);
          cur = task;
          count = 1;
        }
      }
    }
    if (count == 1) {
      return -1;
    } else {
      res += count / 3 + (count % 3 > 0 ? 1 : 0);
    }
    return res;
  }
}
