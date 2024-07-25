package com.wen.repository.solution2800To2899;

import org.junit.Assert;
import org.junit.Test;

public class Solution2840To2849Test {
  Solution2840To2849 solution = new Solution2840To2849();

  @Test
  public void minimumOperations() {
    Assert.assertEquals(2, solution.minimumOperations("2245047"));
    Assert.assertEquals(3, solution.minimumOperations("2908305"));
    Assert.assertEquals(1, solution.minimumOperations("10"));
  }
}
