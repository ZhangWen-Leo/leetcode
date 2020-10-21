package com.wen.repository.solution0001To0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution0050To0059 {

    /**
     * 50. Pow(x, n)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 2) {
            return x * x;
        }

        if (n % 2 == 0) {
            return myPow(myPow(x, n/2), 2);
        }
        else {
            return myPow(x, n-1) * x;
        }
    }

    /**
     * 51. N-Queens
     */
    private boolean[][] checkBoard;
    private int size = 0;
    List<List<String>> queenResult;
    public List<List<String>> solveNQueens(int n) {
        checkBoard = new boolean[n][n];
        size = n;
        queenResult = new ArrayList<>();

        solveNQueens(n, 0);

        return queenResult;
    }
    private void solveNQueens(int n, int level) {
        for (int i = 0; i < size; i++) {
            if (!checkPosition(level, i)) {
                checkBoard[level][i] = true;
                if (level == n - 1) {
                    getAResult();
                }
                else {
                    solveNQueens(n, level+1);
                }
                checkBoard[level][i] = false;
            }
        }
    }
    private void getAResult() {
        List<String> aResult = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringBuilder resultBuilder = new StringBuilder(size);
            for (int j = 0; j < size; j++) {
                resultBuilder.append(checkBoard[i][j] ? 'Q' : '.');
            }
            aResult.add(resultBuilder.toString());
        }

        queenResult.add(aResult);
    }
    private boolean checkPosition(int x, int y) {
        for (int i = 0; i < size; i++) {
            if (checkBoard[x][i] || checkBoard[i][y]) {
                return true;
            }
        }
        for (int i = 1 - size; i < size; i++) {
            int positionAX = x + i, positionAY = y + i;
            int positionBX = x - i, positionBY = y + i;

            if (checkRange(positionAX) && checkRange(positionAY) && checkBoard[positionAX][positionAY]) {
                return true;
            }
            if (checkRange(positionBX) && checkRange(positionBY) && checkBoard[positionBX][positionBY]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkRange(int x) {
        return x >= 0 && x < size;
    }

    /**
     * 52. N-Queens II
     */
    private int queenCount = 0;
    public int totalNQueens(int n) {
        checkBoard = new boolean[n][n];
        size = n;

        totalNQueens(n, 0);

        return queenCount;
    }
    public void totalNQueens(int n, int level) {
        for (int i = 0; i < n; i++) {
            if (!checkPosition(level, i)) {
                if (level == n - 1) {
                    queenCount++;
                }
                else {
                    checkBoard[level][i] = true;
                    totalNQueens(n, level + 1);
                    checkBoard[level][i] = false;
                }
            }
        }
    }

    /**
     * 53. Maximum Subarray
     */
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length);
    }
    public int maxSubArray(int[] nums, int start, int end) {
        if (end - start == 1) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, current;
        current = 0;
        for (int i = mid - 1; i >= start; i--) {
            current += nums[i];
            leftMax = Integer.max(leftMax, current);
        }
        current = 0;
        for (int i = mid; i < end; i++) {
            current += nums[i];
            rightMax = Integer.max(rightMax, current);
        }

        int max;
        max = Integer.max(maxSubArray(nums, start, mid), maxSubArray(nums, mid, end));
        max = Integer.max(max, leftMax + rightMax);

        return max;
    }
//    public int maxSubArray(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i-1];
//        }
//
//        int max = nums[0];
//        int min = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] - min > max) {
//                max = nums[i] - min;
//            }
//            if (nums[i] < min) {
//                min = nums[i];
//            }
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
//
//        return max;
//    }

    /**
     * 54. Spiral Matrix
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int count = 0, x = 0, y = 0;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        while (true) {
            // 向右
            if (y >= matrix[x].length - count) {
                return list;
            }
            while (y < matrix[x].length - count) {
                list.add(matrix[x][y++]);
            }
            y--;
            x++;

            // 向下
            if (x >= matrix.length - count) {
                return list;
            }
            while (x < matrix.length - count) {
                list.add(matrix[x++][y]);
            }
            x--;
            y--;

            // 向左
            if (y < count) {
                return list;
            }
            while (y >= count) {
                list.add(matrix[x][y--]);
            }
            y++;
            x--;
            count++;

            // 向上
            if (x < count) {
                return list;
            }
            while (x >= count) {
                list.add(matrix[x--][y]);
            }
            x++;
            y++;
        }
    }

    /**
     * 55. Jump Game
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int length = nums[0];
        for (int i = 1; i <= length && i < nums.length; i++) {
            length = Math.max(i + nums[i], length);
        }
        if (length >= nums.length-1) {
            return true;
        }
        else {
            return false;
        }
    }
}
