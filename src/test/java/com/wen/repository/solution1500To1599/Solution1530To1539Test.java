package com.wen.repository.solution1500To1599;

import org.junit.Assert;
import org.junit.Test;

public class Solution1530To1539Test {
  private final Solution1530To1539 solution = new Solution1530To1539();

  @Test
  public void getWinner() {
    Assert.assertEquals(solution.getWinner(new int[]{2,1,3,5,4,6,7}, 2), 5);
    Assert.assertEquals(solution.getWinner(new int[]{3,2,1}, 10), 3);
    Assert.assertEquals(solution.getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7), 9);
    Assert.assertEquals(solution.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000), 99);
  }
}
