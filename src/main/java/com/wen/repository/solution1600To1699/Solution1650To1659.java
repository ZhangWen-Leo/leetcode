package com.wen.repository.solution1600To1699;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1650To1659 {
  /**
   * 1657. Determine if Two Strings Are Close
   *
   * <p>1 <= word1.length, word2.length <= 10^5</p>
   * <p>word1 and word2 contain only lowercase English letters.</p>
   */
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    int[] count1 = new int[26];
    int[] count2 = new int[26];
    Arrays.fill(count1, 0);
    Arrays.fill(count2, 0);
    for (int i = 0; i < word1.length(); i++) {
      count1[word1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < word2.length(); i++) {
      count2[word2.charAt(i) - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
        return false;
      }
    }
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int count : count1) {
      frequencyMap.merge(count, 1, Integer::sum);
    }
    for (int count : count2) {
      Integer frequency = frequencyMap.get(count);
      if (frequency == null || frequency == 0) {
        return false;
      } else {
        frequencyMap.put(count, frequency - 1);
      }
    }
    return true;
  }
}
