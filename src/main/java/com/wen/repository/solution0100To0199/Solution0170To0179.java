package com.wen.repository.solution0100To0199;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution0170To0179 {

    /**
     * 170. Two Sum III - Data structure design
     *
     * 见design/TwoSum.java
     */

    /**
     * 171. Excel Sheet Column Number
     */
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length()-1, pow = 0; i >= 0; i--, pow++) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, pow);
        }
        return result;
    }

    /**
     * 172. Factorial Trailing Zeroes
     */
    public int trailingZeroes(int n) {
        int count = 0;
        long i = 5;
        while (n >= i) {
            count += n / i;
            i *= 5;
        }

        return count;
    }

    /**
     * 173. Binary Search Tree Iterator
     *
     * 见design/BSTIterator
     */

    /**
     * 174. Dungeon Game
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int len = m + n - 1;
        dungeon[m-1][n-1] = dungeon[m-1][n-1] < 0 ? -dungeon[m-1][n-1] + 1 : 1;
        for (int i = 1; i < len; i++) {
            int x, y;
            if (i < n) {
                x = m - 1;
                y = n - 1 - i;
            }
            else {
                x = m - (i - n + 2);
                y = 0;
            }

            while (x >= 0 && y < n) {
                dungeon[x][y] = Math.min(getDungeon(dungeon, x+1, y), getDungeon(dungeon, x, y+1)) - dungeon[x][y];
                if (dungeon[x][y] <= 0) {
                    dungeon[x][y] = 1;
                }

                x--;
                y++;
            }
        }

        return dungeon[0][0];
    }
    private int getDungeon(int[][] dungeon, int x, int y) {
        if (x >= dungeon.length || y >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        else {
            return dungeon[x][y];
        }
    }

    /**
     * 175 - 178
     *
     * TODO
     * SQL
     */

    /**
     * 179. Largest Number
     */
    private final int MAX_DIGIT = 10;
    public String largestNumber(int[] nums) {
        int len = nums.length;
        int[][] numsMatrix = new int[len][MAX_DIGIT];
        for (int i = 0; i < len; i++) {
            Arrays.fill(numsMatrix[i], -1);
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int figure = MAX_DIGIT - 1;
            if (num == 0) {
                numsMatrix[i][0] = 0;
                continue;
            }
            while (num / (int) Math.pow(10, figure) == 0) {
                figure--;
            }
            int j = 0;
            while (figure >= 0) {
                numsMatrix[i][j++] = num / (int) Math.pow(10, figure);
                num %= Math.pow(10, figure);
                figure--;
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return compareNumberInList(o1, o2);
            }
        });
        for (int i = 0; i < len; i++) {
            maxHeap.offer(numsMatrix[i]);
        }
        if (maxHeap.peek()[0] == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] num = maxHeap.poll();
            for (int i = 0; i < num.length && num[i] >= 0; i++) {
                result.append(num[i]);
            }
        }

        return result.toString();
    }
    private int compareNumberInList(int[] num1, int[] num2) {
        return compareNumberInList(num1, 0, num2, 0);
    }
    private int compareNumberInList(int[] num1, int start1, int[] num2, int start2) {
        while (isValid(num1, start1) && isValid(num2, start2)) {
            if (num1[start1] > num2[start2]) {
                return -1;
            }
            else if (num1[start1] < num2[start2]) {
                return 1;
            }
            else {
                start1++;
                start2++;
            }
        }
        if (!isValid(num1, start1) && !isValid(num2, start2)) {
            return 0;
        }
        else if (!isValid(num1, start1)) {
            return compareNumberInList(num1, 0, num2, start2);
        }
        else {
            return compareNumberInList(num1, start1, num2, 0);
        }
    }
    private boolean isValid(int[] num, int index) {
        return index < MAX_DIGIT && num[index] >= 0;
    }
}
