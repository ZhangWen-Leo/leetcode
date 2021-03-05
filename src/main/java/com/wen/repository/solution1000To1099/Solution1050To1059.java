package com.wen.repository.solution1000To1099;

import java.util.HashMap;

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

    /**
     * 1056. Confusing Number
     */
    public boolean confusingNumber(int N) {
        int end = 10, start = 10;
        int[] digits = new int[end];
        do {
            digits[--start] = N % 10;
            N /= 10;
        } while (N > 0);
        HashMap<Integer, Integer> rotate = new HashMap<>();
        rotate.put(0, 0);
        rotate.put(1, 1);
        rotate.put(6, 9);
        rotate.put(8, 8);
        rotate.put(9, 6);

        int left = start, right = end - 1;
        boolean res = false;
        while (left <= right) {
            if (!rotate.containsKey(digits[left]) || !rotate.containsKey(digits[right])) {
                return false;
            }
            else if (rotate.get(digits[left]) != digits[right]) {
                res =  true;
            }
            left++;
            right--;
        }
        return res;
    }
}
