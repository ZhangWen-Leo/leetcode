package com.wen.repository.solution0800To0899;


import org.junit.Assert;
import org.junit.Test;

public class Solution0880To0889Test {
  Solution0880To0889 solution = new Solution0880To0889();

  @Test
  public void numRescueBoats() {
//    Assert.assertEquals(1, solution.numRescueBoats(new int[]{1, 2}, 3));
//    Assert.assertEquals(3, solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
//    Assert.assertEquals(4, solution.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
//    Assert.assertEquals(3, solution.numRescueBoats(new int[]{1, 3, 3, 4, 5}, 8));
    Assert.assertEquals(53, solution.numRescueBoats(new int[]{8, 3, 8, 3, 10, 2, 9, 1, 3, 6, 6, 4, 2, 3, 3, 8, 10, 6,
      1, 8, 4, 4, 6, 3, 10, 2, 5
      , 3, 6, 6, 7, 6, 5, 7, 5, 8, 8, 3, 4, 7, 2, 7, 4, 6, 2, 7, 4, 5, 5, 5, 7, 4, 7, 1, 4, 8, 1, 7, 1, 5, 9, 1, 6, 1
      , 9, 7, 8, 7, 1, 1, 7, 10, 9, 7, 8, 3, 8, 3, 2, 5, 4, 2
      , 5, 9, 5, 5, 8, 6, 2, 10, 5, 8, 4, 9, 4, 3, 2, 10, 6, 1}, 10));
  }

  @Test
  public void fairCandySwap() {
    Assert.assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2}));
    Assert.assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3}));
    Assert.assertArrayEquals(new int[]{2, 3}, solution.fairCandySwap(new int[]{2}, new int[]{1, 3}));
  }
}
