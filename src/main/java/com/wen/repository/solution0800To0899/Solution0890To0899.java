package com.wen.repository.solution0800To0899;

public class Solution0890To0899 {

    /**
     * 896. Monotonic Array
     */
    public boolean isMonotonic(int[] A) {
        int tend = 0, len = A.length;

        for (int i = 1; i < len; i++) {
            if (tend == 0) {
                if (A[i] > A[i-1]) {
                    tend = 1;
                }
                else if (A[i] < A[i-1]) {
                    tend = -1;
                }
            }
            else if (tend == 1 && A[i] < A[i-1]) {
                return false;
            }
            else if (tend == -1 && A[i] > A[i-1]) {
                return false;
            }
        }

        return true;
    }
}
