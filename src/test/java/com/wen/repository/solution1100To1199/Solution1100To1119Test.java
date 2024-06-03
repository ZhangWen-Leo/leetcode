package com.wen.repository.solution1100To1199;

import org.junit.Assert;
import org.junit.Test;

public class Solution1100To1119Test {
  Solution1100To1119 solution = new Solution1100To1119();

  @Test
  public void distributeCandies() {
    Assert.assertArrayEquals(new int[]{1, 2, 3, 1}, solution.distributeCandies(7, 4));
    Assert.assertArrayEquals(new int[]{5, 2, 3}, solution.distributeCandies(10, 3));
    Assert.assertArrayEquals(new int[]{28, 27, 21, 24}, solution.distributeCandies(100, 4));
  }
}
