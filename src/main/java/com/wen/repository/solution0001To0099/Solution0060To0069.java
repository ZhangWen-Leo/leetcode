package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0060To0069 {

    /**
     * 60. Permutation Sequence
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int x = 1;
        for (int i = n; i >= 1; i--) {
            x *= i;
        }

        StringBuilder result = new StringBuilder();
        k--;
        for (int i = n; i > 0; i--) {
            x /= i;
            result.append(list.get(k / x));
            list.remove(k / x);
            k %= x;
        }

        return result.toString();
    }

    /**
     * 61. Rotate List
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }
        if (length == 0) {
            return head;
        }
        if (k >= length) {
            k %= length;
        }
        if (k == 0) {
            return head;
        }

        ListNode nodeA, nodeB, nodeC;
        nodeA = head;
        nodeB = nodeA.next;
        nodeC = nodeA;
        while (k-- > 0) {
            nodeC = nodeC.next;
        }

        while (nodeC.next != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            nodeC = nodeC.next;
        }
        nodeA.next = null;
        nodeC.next = head;
        return nodeB;
    }

    /**
     * 62. Unique Paths
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 1;
                }
                else {
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }

    /**
     * 63. Unique Paths II
     */
    private int[][] checkGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        checkGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < checkGrid.length; i++) {
            for (int j = 0; j < checkGrid[i].length; j++) {
                checkGrid[i][j] = -1;
            }
        }

        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }
    private int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        if (checkGrid[x][y] >= 0) {
            return checkGrid[x][y];
        }

        int result = 0;
        if (obstacleGrid[x][y] == 1) {
            checkGrid[x][y] = 0;
            return 0;
        }
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            checkGrid[x][y] = 1;
            return 1;
        }
        if (x + 1 < obstacleGrid.length) {
            result += uniquePathsWithObstacles(obstacleGrid, x + 1, y);
        }
        if (y + 1 < obstacleGrid[0].length) {
            result += uniquePathsWithObstacles(obstacleGrid, x, y + 1);
        }
        checkGrid[x][y] = result;
        return result;
    }

    /**
     * 64. Minimum Path Sum
     */
    private int[][] minimumGrid;
    private int[][] countForMinimum;
    public int minPathSum(int[][] grid) {
        minimumGrid = grid;
        int m = grid.length, n = grid[0].length;
        countForMinimum = new int[m][n];

        return minPathSum(0, 0);
    }
    private int minPathSum(int x, int y) {
        if (countForMinimum[x][y] > 0) {
            return countForMinimum[x][y];
        }

        int min = Integer.MAX_VALUE;
        int m = minimumGrid.length, n = minimumGrid[0].length;

        if (x == m - 1 && y == n - 1) {
            countForMinimum[x][y] = minimumGrid[x][y];
            return countForMinimum[x][y];
        }
        if (x + 1 < m) {
            min = Integer.min(minPathSum(x + 1, y), min);
        }
        if (y + 1 < n) {
            min = Integer.min(minPathSum(x, y + 1), min);
        }
        countForMinimum[x][y] = min + minimumGrid[x][y];

        return countForMinimum[x][y];
    }
}
