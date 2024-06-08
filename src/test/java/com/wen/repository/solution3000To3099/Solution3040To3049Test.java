package com.wen.repository.solution3000To3099;

import org.junit.Assert;
import org.junit.Test;

public class Solution3040To3049Test {
  Solution3040To3049 solution = new Solution3040To3049();

  @Test
  public void maxOperations() {
    Assert.assertEquals(3, solution.maxOperations(new int[]{3, 2, 1, 2, 3, 4}));
    Assert.assertEquals(2, solution.maxOperations(new int[]{3, 2, 6, 1, 4}));
    Assert.assertEquals(1, solution.maxOperations(new int[]{1, 9}));
  }
}
