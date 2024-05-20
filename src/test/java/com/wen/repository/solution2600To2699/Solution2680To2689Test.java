package com.wen.repository.solution2600To2699;

import org.junit.Assert;
import org.junit.Test;

public class Solution2680To2689Test {
  Solution2680To2689 solution = new Solution2680To2689();

  @Test
  public void maxMoves() {
    Assert.assertEquals(
            solution.maxMoves(new int[][]{
                    {2, 4, 3, 5},
                    {5, 4, 9, 3},
                    {3, 4, 2, 11},
                    {10, 9, 13, 15}
            }),
            3
    );
    Assert.assertEquals(
            solution.maxMoves(new int[][]{
                    {3, 2, 4},
                    {2, 1, 9},
                    {1, 1, 7}
            }),
            0
    );
  }
}
