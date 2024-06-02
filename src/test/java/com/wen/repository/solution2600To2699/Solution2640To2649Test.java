package com.wen.repository.solution2600To2699;

import org.junit.Assert;
import org.junit.Test;

public class Solution2640To2649Test {
  Solution2640To2649 solution = new Solution2640To2649();

  @Test
  public void addMinimum() {
    Assert.assertEquals(2, solution.addMinimum("b"));
    Assert.assertEquals(6, solution.addMinimum("aaa"));
    Assert.assertEquals(0, solution.addMinimum("abc"));
  }
}
