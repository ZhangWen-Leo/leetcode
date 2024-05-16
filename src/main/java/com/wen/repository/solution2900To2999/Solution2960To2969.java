package com.wen.repository.solution2900To2999;

public class Solution2960To2969 {
  /**
   * 2960. Count Tested Devices After Test Operations
   *
   * <p>1 <= n == batteryPercentages.length <= 100</p>
   * <p>0 <= batteryPercentages[i] <= 100</p>
   */
  public int countTestedDevices(int[] batteryPercentages) {
    int count = 0;
    for (int batteryPercentage : batteryPercentages) {
      if (batteryPercentage > count) {
        count++;
      }
    }
    return count;
  }
}
