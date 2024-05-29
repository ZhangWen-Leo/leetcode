package com.wen.repository.solution0800To0899;

import org.junit.Assert;
import org.junit.Test;

public class Solution0870To0879Test {

  Solution0870To0879 solution = new Solution0870To0879();

  @Test
  public void middleNode() {
    Solution0870To0879.ListNode node6 = new Solution0870To0879.ListNode(6);
    Solution0870To0879.ListNode node5 = new Solution0870To0879.ListNode(5, node6);
    Solution0870To0879.ListNode node4 = new Solution0870To0879.ListNode(4, node5);
    Solution0870To0879.ListNode node3 = new Solution0870To0879.ListNode(3, node4);
    Solution0870To0879.ListNode node2 = new Solution0870To0879.ListNode(2, node3);
    Solution0870To0879.ListNode node1 = new Solution0870To0879.ListNode(1, node2);
    Assert.assertEquals(node4, solution.middleNode(node1));
    Assert.assertEquals(node4, solution.middleNode(node2));
    Assert.assertEquals(node5, solution.middleNode(node3));
    Assert.assertEquals(node5, solution.middleNode(node4));
    Assert.assertEquals(node6, solution.middleNode(node5));
    Assert.assertEquals(node6, solution.middleNode(node6));
  }

  @Test
  public void profitableSchemes() {
    Assert.assertEquals(2, solution.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    Assert.assertEquals(7, solution.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
  }
}