package com.wen.repository.solution0800To0899;

public class Solution0870To0879 {

  /**
   * 876. Middle of the Linked List
   *
   * <p>The number of nodes in the list is in the range [1, 100].</p>
   * <p>1 <= Node.val <= 100</p>
   */
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast == null) {
        break;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * 879. Profitable Schemes
   *
   * <p>1 <= n <= 100</p>
   * <p>0 <= minProfit <= 100</p>
   * <p>1 <= group.length <= 100</p>
   * <p>1 <= group[i] <= 100</p>
   * <p>profit.length == group.length</p>
   * <p>0 <= profit[i] <= 100</p>
   */
  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    len = group.length;
    profitDp = new int[n + 1][minProfit + 1][len];
    this.group = group;
    this.profit = profit;
    sum = new int[len];
    sum[len - 1] = profit[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      sum[i] = profit[i] + sum[i + 1];
    }

    return getProfit(n, minProfit, 0);
  }

  private int[][][] profitDp;
  private int[] group;
  private int[] profit;
  private int[] sum;
  private int len;
  private static final int mod = 1000000007;

  private int getProfit(int n, int target, int start) {
    if (start >= len) {
      return target <= 0 ? 1 : 0;
    }
    if (n == 0) {
      return target <= 0 ? 1 : 0;
    }
    if (target <= 0) {
      target = 0;
    }
    if (target > sum[start]) {
      return 0;
    }
    if (profitDp[n][target][start] > 0) {
      return profitDp[n][target][start];
    } else if (group[start] <= n) {
      profitDp[n][target][start] += getProfit(n - 1, target - profit[start], start + 1);
    }
    profitDp[n][target][start] += getProfit(n, target, start + 1);
    profitDp[n][target][start] %= mod;

    return profitDp[n][target][start];
  }
}
