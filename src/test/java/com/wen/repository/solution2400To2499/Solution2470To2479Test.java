package com.wen.repository.solution2400To2499;

import com.wen.util.WenArrays;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2470To2479Test {
  Solution2470To2479 solution = new Solution2470To2479();

  @Test
  public void closestNodes() {
    Solution2470To2479.TreeNode root = new Solution2470To2479.TreeNode(6,
      new Solution2470To2479.TreeNode(2,
        new Solution2470To2479.TreeNode(1),
        new Solution2470To2479.TreeNode(4)
      ),
      new Solution2470To2479.TreeNode(13,
        new Solution2470To2479.TreeNode(9),
        new Solution2470To2479.TreeNode(15,
          new Solution2470To2479.TreeNode(14),
          null
        )
      )
    );
    ArrayList<Integer> queries = WenArrays.toArrayList(new Integer[]{2, 5, 16});
    List<List<Integer>> result = solution.closestNodes(root, queries);
    //noinspection unchecked
    ArrayList<ArrayList<Integer>> expected = WenArrays.toArrayList(new ArrayList[]{
      WenArrays.toArrayList(new Integer[]{2, 2}),
      WenArrays.toArrayList(new Integer[]{4, 6}),
      WenArrays.toArrayList(new Integer[]{15, -1}),
    });
    for (int i = 0; i < result.size(); i++) {
      Assert.assertArrayEquals(expected.get(i).toArray(), result.get(i).toArray());
    }
  }
}
