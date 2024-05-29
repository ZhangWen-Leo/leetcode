package com.wen.repository.solution2900To2999;

import org.junit.Assert;
import org.junit.Test;

public class Solution2980To2989Test {

  Solution2980To2989 solution = new Solution2980To2989();

  @Test
  public void maximumLength() {
    Assert.assertEquals(2, solution.maximumLength("aaaa"));
    Assert.assertEquals(-1, solution.maximumLength("abcdef"));
    Assert.assertEquals(1, solution.maximumLength("abcaba"));
    Assert.assertEquals(1, solution.maximumLength("aaba"));
    Assert.assertEquals(1, solution.maximumLength("aabaa"));
    Assert.assertEquals(2, solution.maximumLength("zzzcczz"));
  }
}
