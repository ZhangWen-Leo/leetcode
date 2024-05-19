package com.wen.repository.solution3000To3099;

import org.junit.Assert;
import org.junit.Test;

public class Solution3060To3069Test {
  Solution3060To3069 solution = new Solution3060To3069();

  @Test
  public void minOperations() {
    Assert.assertEquals(solution.minOperations(new int[]{2,11,10,1,3}, 10), 3);
    Assert.assertEquals(solution.minOperations(new int[]{1,1,2,4,9}, 1), 0);
    Assert.assertEquals(solution.minOperations(new int[]{1,1,2,4,9}, 9), 4);
  }
}
