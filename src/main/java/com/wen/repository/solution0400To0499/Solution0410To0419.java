package com.wen.repository.solution0400To0499;

import java.util.Arrays;
import java.util.HashSet;

public class Solution0410To0419 {

  /**
   * 416. Partition Equal Subset Sum
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;

    for (int num :
      nums) {
      sum += num;
    }
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;

    // 排序数组
    Arrays.sort(nums);
    HashSet<Integer> set = new HashSet<>();
    set.add(target);

    for (int i = nums.length - 1; i >= 0; i--) {
      HashSet<Integer> cloneSet = (HashSet<Integer>) set.clone();
      for (Integer currentTarget :
        cloneSet) {
        if (nums[i] < currentTarget) {
          set.add(currentTarget - nums[i]);
        } else if (nums[i] == currentTarget) {
          return true;
        }
      }
    }

    return false;
  }
}
