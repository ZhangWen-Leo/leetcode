package com.wen.repository.solution3000To3099;

import java.util.HashMap;
import java.util.Map;

public class Solution3040To3049 {
  /**
   * 3040. Maximum Number of Operations With the Same Score II
   *
   * <p>2 <= nums.length <= 2000</p>
   * <p>1 <= nums[i] <= 1000</p>
   */
  public int maxOperations(int[] nums) {
    result = new Map[nums.length - 1][nums.length];

    return Math.max(
      maxOperations(nums, 0, nums.length - 1, nums[0] + nums[nums.length - 1]),
      Math.max(
        maxOperations(nums, 0, nums.length - 1, nums[0] + nums[1]),
        maxOperations(nums, 0, nums.length - 1, nums[nums.length - 2] + nums[nums.length - 1])
      )
    );
  }

  private Map<Integer, Integer>[][] result;

  private int maxOperations(int[] nums, int left, int right, int target) {
    if (right - left < 1) {
      return 0;
    }
    if (nums[left] + nums[right] != target && nums[left] + nums[left + 1] != target && nums[right - 1] + nums[right] != target) {
      return 0;
    }
    if (result[left][right] != null && result[left][right].containsKey(target)) {
      return result[left][right].get(target);
    }
    if (result[left][right] == null) {
      result[left][right] = new HashMap<>();
    }
    Map<Integer, Integer> res = result[left][right];

    if (nums[left] + nums[right] == target) {
      res.put(target, 1 + maxOperations(nums, left + 1, right - 1, target));
    }
    if (nums[left] + nums[left + 1] == target) {
      res.put(target, Math.max(res.getOrDefault(target, 0), 1 + maxOperations(nums, left + 2, right, target)));
    }
    if (nums[right - 1] + nums[right] == target) {
      res.put(target, Math.max(res.getOrDefault(target, 0), 1 + maxOperations(nums, left, right - 2, target)));
    }

    return res.get(target);
  }
}
