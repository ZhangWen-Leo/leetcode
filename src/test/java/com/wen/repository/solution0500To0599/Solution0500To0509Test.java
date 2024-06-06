package com.wen.repository.solution0500To0599;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import java.util.Arrays;

public class Solution0500To0509Test {

  private Solution0500To0509 solution = new Solution0500To0509();

  @Test
  public void findMode() {
    TreeNode t2 = new TreeNode(2);
    TreeNode t1 = new TreeNode(1, null, t2);
    System.out.println(Arrays.toString(solution.findMode(t1)));
  }

  @Test
  public void nextGreaterElements() {
    int[] nums = {1, 2, 1};
    int[] res = solution.nextGreaterElements(nums);
    System.out.println(Arrays.toString(res));
  }
}