package com.wen.repository.solution2900To2999;

public class Solution2930To2939 {
  /**
   * 2938. Separate Black and White Balls
   *
   * <p>1 <= n == s.length <= 10^5</p>
   * <p>s[i] is either '0' or '1'</p>
   */
  public long minimumSteps(String s) {
    int count = 0;
    long result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        result += count;
      } else {
        count++;
      }
    }

    return result;
  }
}
