package com.wen.repository.solution0900To0999;

import org.junit.Assert;
import org.junit.Test;

public class Solution0990To0999Test {
  Solution0990To0999 solution = new Solution0990To0999();

  @Test
  public void subarraysWithKDistinct() {
    Assert.assertEquals(
        7,
        solution.subarraysWithKDistinct(new int[]{
            1, 2, 1, 2, 3
        }, 2));
    Assert.assertEquals(
        3,
        solution.subarraysWithKDistinct(new int[]{
            1, 2, 1, 3, 4
        }, 3)
    );
    Assert.assertEquals(
        23,
        solution.subarraysWithKDistinct(new int[]{
            2, 2, 1, 2, 2, 2, 1, 1
        }, 2)
    );
    Assert.assertEquals(
        0,
        solution.subarraysWithKDistinct(new int[]{
            2, 1, 2, 1, 1
        }, 3)
    );
  }

  @Test
  public void orangesRotting() {
    Assert.assertEquals(solution.orangesRotting(new int[][]{
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    }), 4);
    Assert.assertEquals(solution.orangesRotting(new int[][]{
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    }), -1);
    Assert.assertEquals(solution.orangesRotting(new int[][]{
        {0, 2},
    }), 0);
  }
}
