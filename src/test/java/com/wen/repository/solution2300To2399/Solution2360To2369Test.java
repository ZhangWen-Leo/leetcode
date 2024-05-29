package com.wen.repository.solution2300To2399;

import org.junit.Assert;
import org.junit.Test;

public class Solution2360To2369Test {
  Solution2360To2369 solution = new Solution2360To2369();

  @Test
  public void validPartition() {
    Assert.assertTrue(solution.validPartition(new int[]{4, 4, 4, 5, 6}));
    Assert.assertFalse(solution.validPartition(new int[]{1, 1, 1, 2}));
  }
}
