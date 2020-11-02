package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0220To0229 {

    /**
     * 221. Maximal Square
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] numMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            numMatrix[i][0] = matrix[i][0] - 48;
        }
        for (int i = 0; i < n; i++) {
            numMatrix[0][i] = matrix[0][i] - 48;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int min = Integer.min(numMatrix[i-1][j-1], Integer.min(numMatrix[i-1][j], numMatrix[i][j-1]));

                    numMatrix[i][j] = min == 0 ? 1 : min + 1;
                }
                else {
                    numMatrix[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Integer.max(max, numMatrix[i][j]);
            }
        }

        return max * max;
    }

    /**
     * 226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
