package com.wen.repository.solution0300To0399;

import java.util.HashSet;
import java.util.Set;

public class Solution0380To0389 {

    /**
     * 387. First Unique Character in a String
     */
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
