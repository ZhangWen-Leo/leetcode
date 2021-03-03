package com.wen.repository.solution0300To0399.design;

public class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n;
        if (m == 0) {
            n = 0;
        }
        else {
            n = matrix[0].length;
        }
        sum = new int[m+1][n+1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}
