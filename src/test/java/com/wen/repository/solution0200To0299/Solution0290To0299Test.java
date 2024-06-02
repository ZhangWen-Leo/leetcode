package com.wen.repository.solution0200To0299;

import org.junit.Assert;
import org.junit.Test;

public class Solution0290To0299Test {
  Solution0290To0299 solution = new Solution0290To0299();

  @Test
  public void canWinNim() {
    Assert.assertFalse(solution.canWinNim(4));
    Assert.assertTrue(solution.canWinNim(1));
    Assert.assertTrue(solution.canWinNim(2));
    Assert.assertFalse(solution.canWinNim(100));
    Assert.assertTrue(solution.canWinNim(99));
    Assert.assertFalse(solution.canWinNim(Integer.MAX_VALUE - 3));
    Assert.assertTrue(solution.canWinNim(Integer.MAX_VALUE));
  }
}
