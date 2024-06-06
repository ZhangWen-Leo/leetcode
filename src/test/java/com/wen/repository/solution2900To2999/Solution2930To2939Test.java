package com.wen.repository.solution2900To2999;

import org.junit.Assert;
import org.junit.Test;

public class Solution2930To2939Test {
  Solution2930To2939 solution = new Solution2930To2939();

  @Test
  public void minimumSteps() {
    Assert.assertEquals(1, solution.minimumSteps("101"));
    Assert.assertEquals(2, solution.minimumSteps("100"));
    Assert.assertEquals(0, solution.minimumSteps("0111"));
    Assert.assertEquals(381, solution.minimumSteps("10111010111110001110000111001010101010100000111011011"));
  }
}
