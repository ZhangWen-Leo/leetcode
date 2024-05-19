package com.wen.repository.solution3000To3099;

public class Solution3060To3069 {
  /**
   * 3065. Minimum Operations to Exceed Threshold Value I
   *
   * <p>1 <= nums.length <= 50</p>
   * <p>1 <= nums[i] <= 10^9</p>
   * <p>1 <= k <= 10^9</p>
   * <p>The input is generated such that there is at least one index i such that nums[i] >= k.</p>
   */
  public int minOperations(int[] nums, int k) {
    int count = 0;
    for (int num: nums) {
      if (num < k) {
        count++;
      }
    }
    return count;
  }
}
