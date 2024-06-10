package com.wen.repository.solution0800To0899;

import java.util.HashSet;

public class Solution0880To0889 {

  /**
   * 888. Fair Candy Swap
   * <p>
   * 1 <= A.length <= 10000
   * 1 <= B.length <= 10000
   * 1 <= A[i] <= 100000
   * 1 <= B[i] <= 100000
   */
  public int[] fairCandySwap(int[] A, int[] B) {
    int aliceSum = 0, bobSum = 0;
    HashSet<Integer> bobBars = new HashSet<>();
    for (int k : A) {
      aliceSum += k;
    }
    for (int j : B) {
      bobSum += j;
      bobBars.add(j);
    }

    int exchange = (bobSum - aliceSum) / 2;
    for (int aliceBar : A) {
      if (bobBars.contains(aliceBar + exchange)) {
        return new int[]{aliceBar, aliceBar + exchange};
      }
    }

    return null;
  }
}
