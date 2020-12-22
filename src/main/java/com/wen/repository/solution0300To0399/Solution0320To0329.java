package com.wen.repository.solution0300To0399;

import com.wen.dataStructure.ListNode;

import java.util.Stack;

public class Solution0320To0329 {

    /**
     * 321. Create Maximum Number
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];
        int start1 = 0, start2 = 0, end1, end2, l = 0;

        while (k > 0) {
            end1 = k > n - start2 ? m - (k-n+start2) : m - 1;
            end2 = k > m - start1 ? n - (k-m+start1) : n - 1;

            int max = -1;
            int[] maxIndex = {1, 0};
            boolean hasfound = false;
            for (int i = start1; i <= end1; i++) {
                if (nums1[i] > max) {
                    max = nums1[i];
                    maxIndex[0] = 1;
                    maxIndex[1] = i;
                    if (max == 9) {
                        hasfound = true;
                        break;
                    }
                }
            }
            if (!hasfound) {
                for (int i = start2; i <= end2; i++) {
                    if (nums2[i] > max) {
                        max = nums2[i];
                        maxIndex[0] = 2;
                        maxIndex[1] = i;
                        if (max == 9) {
                            break;
                        }
                    }
                }
            }

            if (maxIndex[0] == 1) {
                result[l++] = nums1[maxIndex[1]];
                start1 = maxIndex[1] + 1;
            }
            else {
                result[l++] = nums2[maxIndex[1]];
                start2 = maxIndex[1] + 1;
            }
            k--;
        }

        return result;
    }
    private void initMax(int length, int[] num, int[] max) {
        if (length > 0) {
            max[length-1] = num[length-1];
            for (int i = length-2; i >= 0; i--) {
                if (num[i] > max[i+1]) {
                    max[i] = num[i];
                }
                else {
                    max[i] = max[i+1];
                }
            }
        }
    }

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
