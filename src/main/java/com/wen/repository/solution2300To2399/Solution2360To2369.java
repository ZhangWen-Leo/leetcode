package com.wen.repository.solution2300To2399;

public class Solution2360To2369 {
  /**
   * 2369. Check if There is a Valid Partition For The Array
   *
   * <p>2 <= nums.length <= 10^5</p>
   * <p>1 <= nums[i] <= 10^6</p>
   */
  public boolean validPartition(int[] nums) {
    boolean[] check = new boolean[nums.length + 1];

    check[nums.length] = true;
    for (int i = nums.length - 2; i >= 0; i--) {
      this.checkSingleNum(i, nums, check);
    }
    return check[0];
  }

  private void checkSingleNum(int i, int[] nums, boolean[] check) {
    if (check[i + 2] && nums[i] == nums[i + 1]) {
      check[i] = true;
    } else if (i + 2 < nums.length && check[i + 3]) {
      if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
        check[i] = true;
      } else if (nums[i] == nums[i + 1] - 1 && nums[i] == nums[i + 2] - 2) {
        check[i] = true;
      }
    }
  }
}
