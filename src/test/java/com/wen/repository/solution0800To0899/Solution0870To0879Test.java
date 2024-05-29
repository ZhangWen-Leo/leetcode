package com.wen.repository.solution0800To0899;

import org.junit.Assert;
import org.junit.Test;

public class Solution0870To0879Test {

  Solution0870To0879 solution = new Solution0870To0879();

  @Test
  public void profitableSchemes() {
    Assert.assertEquals(2, solution.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    Assert.assertEquals(7, solution.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
  }
}