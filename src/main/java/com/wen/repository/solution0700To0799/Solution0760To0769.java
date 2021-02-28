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

    /**
     * 766. Toeplitz Matrix
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 20
     * 0 <= matrix[i][j] <= 99
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
