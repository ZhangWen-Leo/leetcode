package com.wen.repository.solution0900To0999;

public class Solution0970To0979 {

    /**
     * 977. Squares of a Sorted Array
     */
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        int left, right, i = 0;

        left = 0;
        while (left < length - 1 && A[left+1] < 0) {
            left++;
        }
        right = left + 1;

        while (i < length && (left >=0 || right < length)) {
            if (left < 0) {
                while (i < length && right < length) {
                    result[i++] = A[right] * A[right];
                    right++;
                }
            }
            else if (right >= length) {
                while (i < length && left >= 0) {
                    result[i++] = A[left] * A[left];
                    left--;
                }
            }
            else {
                int leftSquare = A[left] * A[left];
                int rightSquare = A[right] * A[right];

                if (leftSquare < rightSquare) {
                    result[i++] = leftSquare;
                    left--;
                }
                else {
                    result[i++] = rightSquare;
                    right++;
                }
            }
        }

        return result;
    }
}
