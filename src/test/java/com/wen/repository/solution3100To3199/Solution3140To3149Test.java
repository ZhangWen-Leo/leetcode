package com.wen.repository.solution3100To3199;


import org.junit.Assert;
import org.junit.Test;

public class Solution3140To3149Test {
  Solution3140To3149 solution = new Solution3140To3149();

  @Test
  public void findPermutationDifference() {
    Assert.assertEquals(solution.findPermutationDifference("abc", "bac"), 2);
    Assert.assertEquals(solution.findPermutationDifference("abcde", "edbac"), 12);
    Assert.assertEquals(solution.findPermutationDifference("zse", "sze"), 2);
  }
}
