package com.wen.repository.solution0500To0599;


import org.junit.Assert;
import org.junit.Test;

public class Solution0510To0519Test {
  Solution0510To0519 solution = new Solution0510To0519();

  @Test
  public void change() {
    Assert.assertEquals(4, solution.change(5, new int[]{1, 2, 5}));
    Assert.assertEquals(0, solution.change(3, new int[]{2}));
    Assert.assertEquals(1, solution.change(10, new int[]{10}));
    Assert.assertEquals(234896541, solution.change(1000, new int[]{1, 2, 5, 10, 20, 50, 100}));
    Assert.assertEquals(1, solution.change(0, new int[]{7}));
    Assert.assertEquals(1, solution.change(0, new int[]{1, 2, 5, 10, 20, 50, 100}));
  }
}
