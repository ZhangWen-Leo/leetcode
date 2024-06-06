package com.wen.repository.solution0500To0599;

import java.util.Arrays;

public class Solution0510To0519 {
  /**
   * 518. Coin Change II
   *
   * <p>1 <= coins.length <= 300</p>
   * <p>1 <= coins[i] <= 5000</p>
   * <p>All the values of coins are unique.</p>
   * <p>0 <= amount <= 5000</p>
   */
  public int change(int amount, int[] coins) {
    Arrays.sort(coins);
    result = new int[amount + 1][coins.length];
    Arrays.fill(result[0], 1);
    for (int i = 1; i < amount + 1; i++) {
      Arrays.fill(result[i], -1);
    }
    return this.change(amount, coins, coins.length - 1);
  }

  private int[][] result;

  private int change(int amount, int[] coins, int maxIndex) {
    if (result[amount][maxIndex] >= 0) {
      return result[amount][maxIndex];
    }
    int res = 0;
    for (int i = maxIndex; i >= 0; i--) {
      if (coins[i] <= amount) {
        res += change(amount - coins[i], coins, i);
      }
    }

    result[amount][maxIndex] = res;
    return result[amount][maxIndex];
  }
}
