package com.wen.explore.read.arrayAndString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoDimensionalArray {
    /**
     * 旋转矩阵
     * 见48
     */

    /**
     * 零矩阵
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 对角线遍历
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        int k = 0, i = 0, j = 0;
        boolean up = true;
        while (k < result.length) {
            result[k++] = matrix[i][j];
            if (up) {
                if (j == matrix[0].length - 1) {
                    i++;
                    up = false;
                }
                else if (i == 0) {
                    j++;
                    up = false;
                }
                else {
                    i--;
                    j++;
                }
            }
            else {
                if (i == matrix.length-1) {
                    j++;
                    up = true;
                }
                else if (j == 0) {
                    i++;
                    up = true;
                }
                else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}
