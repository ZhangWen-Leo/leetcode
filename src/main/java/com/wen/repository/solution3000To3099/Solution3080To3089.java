package com.wen.repository.solution3000To3099;

public class Solution3080To3089 {
  /**
   * 3084. Count Substrings Starting and Ending with Given Character
   *
   * <p>1 <= s.length <= 10^5</p>
   * <p>s and c consist only of lowercase English letters.</p>
   */
  public long countSubstrings(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char cc = s.charAt(i);
      if (cc == c) {
        count++;
      }
    }

    return ((long) (count + 1) * count) / 2;
  }
}
