package com.wen.repository.solution0500To0599;

import java.util.HashSet;
import java.util.Set;

public class Solution0570To0579 {
  /**
   * 575. Distribute Candies
   *
   * <p>n == candyType.length</p>
   * <p>2 <= n <= 10^4</p>
   * <p>n is even.</p>
   * <p>-10^5 <= candyType[i] <= 10^5</p>
   */
  public int distributeCandies(int[] candyType) {
    Set<Integer> set = new HashSet<>();
    for (int candy : candyType) {
      set.add(candy);
    }
    return Math.min(set.size(), candyType.length / 2);
  }
}
