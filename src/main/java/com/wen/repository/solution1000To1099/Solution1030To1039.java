package com.wen.repository.solution1000To1099;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1030To1039 {

    /**
     * 1030. Matrix Cells in Distance Order
     *
     * 1 <= R <= 100
     * 1 <= C <= 100
     * 0 <= r0 < R
     * 0 <= c0 < C
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] checkMatrix = new boolean[R][C];
        List<int[]> result = new ArrayList<>(R*C);
        Queue<int[]> queue = new LinkedList<>();

        int[] startNode = new int[]{r0, c0};
        checkMatrix[r0][c0] = true;
        result.add(startNode);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int x = currentNode[0], y = currentNode[1];

            if (x > 0 && !checkMatrix[x-1][y]) {
                int[] addNode = new int[]{x-1, y};
                checkMatrix[x-1][y] = true;
                result.add(addNode);
                queue.offer(addNode);
            }
            if (x < R - 1 && !checkMatrix[x+1][y]) {
                int[] addNode = new int[]{x+1, y};
                checkMatrix[x+1][y] = true;
                result.add(addNode);
                queue.offer(addNode);
            }
            if (y > 0 && !checkMatrix[x][y-1]) {
                int[] addNode = new int[]{x, y-1};
                checkMatrix[x][y-1] = true;
                result.add(addNode);
                queue.offer(addNode);
            }
            if (y < C - 1 && !checkMatrix[x][y+1]) {
                int[] addNode = new int[]{x, y+1};
                checkMatrix[x][y+1] = true;
                result.add(addNode);
                queue.offer(addNode);
            }
        }

        return result.toArray(new int[0][]);
    }
}
