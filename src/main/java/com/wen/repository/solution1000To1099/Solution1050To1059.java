package com.wen.repository.solution1000To1099;

public class Solution1050To1059 {

    /**
     * 1052. Grumpy Bookstore Owner
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, max = 0, cur;
        int len = customers.length;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                max += customers[i];
            }
            else {
                sum += customers[i];
            }
        }
        cur = max;
        for (int i = 0, j = X; j < len; i++, j++) {
            if (grumpy[i] == 1) {
                cur -= customers[i];
            }
            if (grumpy[j] == 1) {
                cur += customers[j];
            }
            else {
                sum += customers[j];
            }
            max = Math.max(max, cur);
        }

        return sum + max;
    }
}
