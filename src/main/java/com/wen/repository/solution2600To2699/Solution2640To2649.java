package com.wen.repository.solution2600To2699;

public class Solution2640To2649 {
  /**
   * 2645. Minimum Additions to Make Valid String
   *
   * <p>1 <= word.length <= 50</p>
   * <p>word consists of letters "a", "b" and "c" only. </p>
   */
  public int addMinimum(String word) {
    char cur = 'c';
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      char next = word.charAt(i);
      result += next <= cur ? (next + 3 - cur) - 1 : next - cur - 1;
      cur = next;
    }
    return result + ('d' - cur - 1);
  }
}
