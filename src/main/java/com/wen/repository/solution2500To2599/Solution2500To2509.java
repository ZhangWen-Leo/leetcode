package com.wen.repository.solution2500To2599;

import java.util.HashMap;
import java.util.Map;

public class Solution2500To2509 {
    /**
     * 2506. 统计相似字符串对的数目
     */
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (String word: words) {
            int kind = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                kind |= 1 << c - 'a';
            }
            int existCount = map.getOrDefault(kind, 0);
            result += existCount;
            map.put(kind, existCount + 1);
        }
        return result;
    }
}
