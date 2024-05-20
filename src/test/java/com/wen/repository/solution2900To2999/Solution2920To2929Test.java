package com.wen.repository.solution2900To2999;

import org.junit.Assert;
import org.junit.Test;

public class Solution2920To2929Test {
  Solution2920To2929 solution = new Solution2920To2929();

  @Test
  public void findChampion() {
    Assert.assertEquals(solution.findChampion(3, new int[][]{{0,1}, {1,2}}), 0);
    Assert.assertEquals(solution.findChampion(4, new int[][]{{0,2}, {1,3}, {1,2}}), -1);
    Assert.assertEquals(solution.findChampion(3, new int[][]{{1,2}}), -1);
  }
}
