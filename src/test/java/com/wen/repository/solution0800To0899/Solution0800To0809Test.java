package com.wen.repository.solution0800To0899;


import org.junit.Assert;
import org.junit.Test;

public class Solution0800To0809Test {
  Solution0800To0809 solution = new Solution0800To0809();

  @Test
  public void uniqueMorseRepresentations() {
    Assert.assertEquals(2, solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    Assert.assertEquals(1, solution.uniqueMorseRepresentations(new String[]{"a"}));
  }
}
