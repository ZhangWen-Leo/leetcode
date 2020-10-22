package com.wen.repository.solution0700To0799;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0760To0769 {

    /**
     * 763. Partition Labels
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 1;

        while (start < S.length()) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                if (!set.contains(S.charAt(i))) {
                    set.add(S.charAt(i));
                    for (int j = S.length() - 1; j >= i && j >= end; j--) {
                        if (S.charAt(j) == S.charAt(i)) {
                            end = j + 1;
                            break;
                        }
                    }
                }
            }

            result.add(end - start);
            start = end;
            end++;
        }

        return result;
    }
}
