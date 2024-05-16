package com.wen.repository.solution2900To2999;

import org.junit.Assert;
import org.junit.Test;

public class Solution2960To2969Test {
  private final Solution2960To2969 solution = new Solution2960To2969();

  @Test
  public void countTestedDevices() {
    Assert.assertEquals(solution.countTestedDevices(new int[]{1, 1, 2, 1, 3}), 3);
    Assert.assertEquals(solution.countTestedDevices(new int[]{0, 1, 2}), 2);
    Assert.assertEquals(solution.countTestedDevices(new int[]{1, 2, 3}), 3);
  }
}
