package com.wen.repository.solution0800To0899;


import org.junit.Assert;
import org.junit.Test;

public class Solution0880To0889Test {
  Solution0880To0889 solution = new Solution0880To0889();

  @Test
  public void fairCandySwap() {
    Assert.assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2}));
    Assert.assertArrayEquals(new int[]{1, 2}, solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3}));
    Assert.assertArrayEquals(new int[]{2, 3}, solution.fairCandySwap(new int[]{2}, new int[]{1, 3}));
  }
}
