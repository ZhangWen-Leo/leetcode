package com.wen.repository.solution0300To0399;

import java.util.List;

public class Solution0330To0339 {

    /**
     * 336. Palindrome Pairs
     *
     * 1 <= words.length <= 5000
     * 0 <= words[i] <= 300
     * words[i] consists of lower-case English letters.
     *
     * TODO
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        return null;
    }

    /**
     * 338. Counting Bits
     */
    public int[] countBits(int num) {
        int len = num + 1;
        int[] res = new int[len];
        if (len > 0) {
            res[0] = 0;
        }
        if (len > 1) {
            res[1] = 1;
        }

        int i = 2, j = 0, from = 2;
        while (i < len) {
            res[i++] = 1 + res[j++];
            if (j >= from) {
                j = 0;
                from = i;
            }
        }

        return res;
    }
}
