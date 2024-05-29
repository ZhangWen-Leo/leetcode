package com.wen.repository.solution0800To0899;

import java.util.HashSet;
import java.util.Set;

public class Solution0800To0809 {
  /**
   * 804. Unique Morse Code Words
   *
   * <p>1 <= words.length <= 100</p>
   * <p>1 <= words[i].length <= 12</p>
   * <p>words[i] consists of lowercase English letters.</p>
   */
  private static final String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
      "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--." +
      "."};

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> morseStringSet = new HashSet<>();
    for (String word : words) {
      StringBuilder morseString = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        morseString.append(morseCode[word.charAt(i) - 'a']);
      }
      morseStringSet.add(morseString.toString());
    }
    return morseStringSet.size();
  }
}
