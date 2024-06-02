package com.wen.repository.solution0500To0599;


import org.junit.Assert;
import org.junit.Test;

public class Solution0570To0579Test {

  Solution0570To0579 solution = new Solution0570To0579();

  @Test
  public void distributeCandies() {
    Assert.assertEquals(3, solution.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    Assert.assertEquals(2, solution.distributeCandies(new int[]{1, 1, 2, 3}));
    Assert.assertEquals(1, solution.distributeCandies(new int[]{6, 6, 6, 6}));
  }
}
