package com.wen.repository.solution3100To3199;

import java.util.Arrays;

public class Solution3140To3149 {
  /**
   * 3146. Permutation Difference between Two Strings
   *
   * <p>1 <= s.length <= 26</p>
   * <p>Each character occurs at most once in s.</p>
   * <p>t is a permutation of s.</p>
   * <p>s consists only of lowercase English letters.</p>
   */
  public int findPermutationDifference(String s, String t) {
    int[] indexArray = new int[26];
    Arrays.fill(indexArray, -1);
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (indexArray[index] >= 0) {
        result += Math.abs(indexArray[index] - i);
      } else {
        indexArray[index] = i;
      }
      index = t.charAt(i) - 'a';
      if (indexArray[index] >= 0) {
        result += Math.abs(indexArray[index] - i);
      } else {
        indexArray[index] = i;
      }
    }

    return result;
  }
}
