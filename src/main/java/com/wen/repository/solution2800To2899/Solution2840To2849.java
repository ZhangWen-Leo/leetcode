package com.wen.repository.solution2800To2899;

public class Solution2840To2849 {
  public int minimumOperations(String num) {
    int fiveIndex = -1, tenIndex = -1;

    for (int i = num.length() - 1; i >= 0; i--) {
      char c = num.charAt(i);
      if (fiveIndex == -1) {
        if (c == '5') {
          fiveIndex = i;
        }
      } else {
        if (c == '2' || c == '7') {
          return num.length() - i - 2;
        }
      }

      if (tenIndex == -1) {
        if (c == '0') {
          tenIndex = i;
        }
      } else {
        if (c == '5' || c == '0') {
          return num.length() - i - 2;
        }
      }
    }
    if (tenIndex >= 0) {
      return num.length() - 1;
    } else {
      return num.length();
    }
  }
}
