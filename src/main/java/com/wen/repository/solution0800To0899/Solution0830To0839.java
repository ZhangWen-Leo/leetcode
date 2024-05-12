package com.wen.repository.solution0800To0899;

import java.util.ArrayList;
import java.util.List;

public class Solution0830To0839 {

    /**
     * 830. Positions of Large Groups
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        int start = 0;
        while (start < s.length()) {
            char c = s.charAt(start);
            int end = start;
            while (end < s.length() && s.charAt(end) == c) {
                end++;
            }
            if (end - start >= 3) {
                List<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end - 1);
                result.add(interval);
            }
            start = end;
        }

        return result;
    }

    /**
     * 832. Flipping an Image
     *
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;

        for (int i = 0; i < m; i++) {
            int left = 0, right = n-1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = 1 - A[i][right];
                A[i][right] = 1 - temp;

                left++;
                right--;
            }
            if (left == right) {
                A[i][left] = 1 - A[i][left];
            }
        }

        return A;
    }

    /**
     * 834. Sum of Distances in Tree
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        // 排列各点等级
        

        return null;
    }

    /**
     * 836. Rectangle Overlap
     *
     * rec1.length == 4
     * rec2.length == 4
     * -10^9 <= rec1[i], rec2[i] <= 10^9
     * rec1 and rec2 represent a valid rectangle with a non-zero area.
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]);
    }
}
