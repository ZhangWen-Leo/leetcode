package com.wen.repository.solution2700To2799;

import org.junit.Assert;
import org.junit.Test;

public class Solution2760To2769Test {
  Solution2760To2769 solution = new Solution2760To2769();

  @Test
  public void theMaximumAchievableX() {
    Assert.assertEquals(solution.theMaximumAchievableX(4, 1), 6);
    Assert.assertEquals(solution.theMaximumAchievableX(3, 2), 7);
  }
}
