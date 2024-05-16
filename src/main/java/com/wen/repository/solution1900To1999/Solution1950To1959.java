package com.wen.repository.solution1900To1999;

public class Solution1950To1959 {
  /**
   * 1953. Maximum Number of Weeks for Which You Can Work
   *
   * <p>n == milestones.length</p>
   * <p>1 <= n <= 10^5</p>
   * <p>1 <= milestones[i] <= 10^9</p>
   */
  public long numberOfWeeks(int[] milestones) {
    int max = 0;

    long sum = 0;
    for (int i: milestones) {
      if (i > max) {
        max = i;
      }
      sum += i;
    }

    if (max > sum - max + 1) {
      return (sum - max) * 2 + 1;
    }
    return sum;
  }
}
