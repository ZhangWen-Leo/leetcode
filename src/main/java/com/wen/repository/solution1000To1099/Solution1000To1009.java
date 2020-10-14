package com.wen.repository.solution1000To1099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1000To1009 {

    /**
     * 1002. Find Common Characters
     */
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        
        if (A.length == 0) {
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> currentMap = new HashMap<>();

            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            }

            for (char key :
                    map.keySet()) {
                map.put(key, Integer.min(map.get(key), currentMap.getOrDefault(key, 0)));
            }
        }

        for (char key :
                map.keySet()) {
            int count = map.get(key);
            while (count-- > 0) {
                list.add(String.valueOf(key));
            }
        }

        return list;
    }
}
