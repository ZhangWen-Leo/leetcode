package com.wen.repository.solution0300To0399;

import com.wen.dataStructure.ListNode;

public class Solution0320To0329 {

    /**
     * 328. Odd Even Linked List
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddTail = head,
                evenTail = head.next,
                oddHead = head,
                evenHead = head.next;
        while (oddTail != null && evenTail != null) {
            if (evenTail.next == null) {
                break;
            }

            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;
        return oddHead;
    }

    /**
     * 329. Longest Increasing Path in a Matrix
     */
    private int[][] pathResults;
    private int[][] pathMatrix;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        pathMatrix = matrix;
        pathResults = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pathResults[i][j] = -1;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Integer.max(max, longestIncreasingPathFrom(i, j));
            }
        }

        return max;
    }
    private int longestIncreasingPathFrom(int x, int y) {
        if (pathResults[x][y] != -1) {
            return pathResults[x][y];
        }

        int max = 1;
        if (x > 0 && pathMatrix[x-1][y] > pathMatrix[x][y]) {
            max = Integer.max(max, 1 + longestIncreasingPathFrom(x-1, y));
        }
        if (x < pathResults.length - 1 && pathMatrix[x+1][y] > pathMatrix[x][y]) {
            max = Integer.max(max, 1 + longestIncreasingPathFrom(x+1, y));
        }
        if (y > 0 && pathMatrix[x][y-1] > pathMatrix[x][y]) {
            max = Integer.max(max, 1 + longestIncreasingPathFrom(x, y-1));
        }
        if (y < pathResults[0].length - 1 && pathMatrix[x][y+1] > pathMatrix[x][y]) {
            max = Integer.max(max, 1 + longestIncreasingPathFrom(x, y+1));
        }

        pathResults[x][y] = max;
        return max;
    }
}
