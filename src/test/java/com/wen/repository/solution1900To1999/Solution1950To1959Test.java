package com.wen.repository.solution1900To1999;

import org.junit.Assert;
import org.junit.Test;

public class Solution1950To1959Test {
  private final Solution1950To1959 solution = new Solution1950To1959();

  @Test
  public void numberOfWeeks() {
    Assert.assertEquals(solution.numberOfWeeks(new int[]{1, 2, 3}), 6);
    Assert.assertEquals(solution.numberOfWeeks(new int[]{5, 2, 1}), 7);
    Assert.assertEquals(solution.numberOfWeeks(new int[]{5}), 1);
    Assert.assertEquals(solution.numberOfWeeks(new int[]{1, 2, 3, 10, 9, 5, 3}), 33);
  }
}
