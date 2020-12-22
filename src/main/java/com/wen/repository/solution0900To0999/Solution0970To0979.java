package com.wen.repository.solution0900To0999;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution0970To0979 {

    /**
     * 973. K Closest Points to Origin
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     */
    public int[][] kClosest(int[][] points, int K) {
        // 特殊情况处理
        if (K == points.length) {
            return points;
        }

        // 设置大顶堆int[0]表示坐标，int[1]表示距离的平方
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < points.length; i++) {
            int distance = sumOfSquares(points[i][0], points[i][1]);
            if (queue.size() < K) {
                queue.offer(new int[]{i, distance});
            }
            else if (distance < queue.peek()[1]) {
                queue.poll();
                queue.offer(new int[]{i, distance});
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K && !queue.isEmpty(); i++) {
            result[i] = points[queue.poll()[0]];
        }

        return result;
    }
    private int sumOfSquares(int a, int b) {
        return a * a + b * b;
    }

    /**
     * 976. Largest Perimeter Triangle
     *
     * 3 <= A.length <= 10000
     * 1 <= A[i] <= 10^6
     *
     * 9ms  82%
     */
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        int i = A.length-1;
        int a = A[i--], b = A[i--], c;
        while (i >= 0) {
            c = A[i--];
            if (a < b + c) {
                return a + b + c;
            }
            else {
                a = b;
                b = c;
            }
        }

        return 0;
    }
    /**
     * 解法2
     *
     * 10ms 24%
     */
    public int largestPerimeter1(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int length :
                A) {
            queue.offer(length);
        }

        int a, b, c;
        a = queue.poll();
        b = queue.poll();
        while (!queue.isEmpty()) {
            c = queue.poll();
            if (a < b + c) {
                return a + b + c;
            }
            else {
                a = b;
                b = c;
            }
        }

        return 0;
    }

    /**
     * 977. Squares of a Sorted Array
     */
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        int left, right, i = 0;

        left = 0;
        while (left < length - 1 && A[left+1] < 0) {
            left++;
        }
        right = left + 1;

        while (i < length && (left >=0 || right < length)) {
            if (left < 0) {
                while (i < length && right < length) {
                    result[i++] = A[right] * A[right];
                    right++;
                }
            }
            else if (right >= length) {
                while (i < length && left >= 0) {
                    result[i++] = A[left] * A[left];
                    left--;
                }
            }
            else {
                int leftSquare = A[left] * A[left];
                int rightSquare = A[right] * A[right];

                if (leftSquare < rightSquare) {
                    result[i++] = leftSquare;
                    left--;
                }
                else {
                    result[i++] = rightSquare;
                    right++;
                }
            }
        }

        return result;
    }
}
