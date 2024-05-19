package com.wen.repository.solution1500To1599;

public class Solution1530To1539 {
  /**
   * 1535. Find the Winner of an Array Game
   *
   * <p>2 <= arr.length <= 10^5</p>
   * <p>1 <= arr[i] <= 10^6</p>
   * <p>arr contains <b>distinct</b> integers.</p>
   * <p>1 <= k <= 10^9</p>
   */
  public int getWinner(int[] arr, int k) {
    int cur = arr[0];
    int combo = 0;
    for (int i = 1; i < arr.length; i++) {
      if (cur > arr[i]) {
        combo++;
      } else {
        cur = arr[i];
        combo = 1;
      }
      if (combo >= k) {
        return cur;
      }
    }
    return cur;
  }
}
