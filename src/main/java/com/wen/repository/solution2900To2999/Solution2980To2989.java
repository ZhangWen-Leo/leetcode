package com.wen.repository.solution2900To2999;

public class Solution2980To2989 {
  /**
   * 2981. Find Longest Special Substring That Occurs Thrice I
   *
   * <p>3 <= s.length <= 50</p>
   * <p>s consists of only lowercase English letters.</p>
   */
  public int maximumLength(String s) {
    this.max3LengthCount = new int['z' - 'a' + 1][3];
    char curChar = s.charAt(0);
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count++;
      if (i + 1 >= s.length() || s.charAt(i + 1) != curChar) {
        this.addSubStr(curChar, count);
        if (i + 1 < s.length()) {
          count = 0;
          curChar = s.charAt(i + 1);
        }
      }
    }

    int maxLength = 0;
    for (int[] ints : this.max3LengthCount) {
      int curCharMaxLength = 0;
      if (ints[0] > 0) {
        curCharMaxLength = Math.max(curCharMaxLength, ints[0] - 2);
      }
      if (ints[1] > 0) {
        curCharMaxLength = Math.max(curCharMaxLength, Math.min(ints[0] - 1, ints[1]));
      }
      curCharMaxLength = Math.max(curCharMaxLength, ints[2]);
      maxLength = Math.max(maxLength, curCharMaxLength);
    }
    return maxLength == 0 ? -1 : maxLength;
  }

  private int[][] max3LengthCount;

  private void addSubStr(char c, int length) {
    int[] max3Length = this.max3LengthCount[c - 'a'];
    if (length >= max3Length[0]) {
      max3Length[2] = max3Length[1];
      max3Length[1] = max3Length[0];
      max3Length[0] = length;
    } else if (length >= max3Length[1]) {
      max3Length[2] = max3Length[1];
      max3Length[1] = length;
    } else if (length >= max3Length[2]) {
      max3Length[2] = length;
    }
  }
}
