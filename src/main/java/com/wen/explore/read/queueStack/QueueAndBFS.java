package com.wen.explore.read.queueStack;

import java.util.*;

public class QueueAndBFS {
    /**
     * 打开转盘锁
     */
    private Queue<int[]> queue1 = new LinkedList<>();
    private Queue<int[]> queue2 = new LinkedList<>();
    private boolean nowOne = true;
    private int[][][][] check = new int[10][10][10][10];
    public int openLock(String[] deadends, String target) {
        int[] targetPoint = new int[4];
        int count = 0;
        queue1.clear();
        queue2.clear();

        for (String s :
                deadends) {
            int[] point = new int[4];
            for (int i = 0; i < 4; i++) {
                point[i] = s.charAt(i) - 48;
            }
            setCheck(point, -1);
        }

        if (getCheck(new int[] {0, 0, 0, 0}) == -1) {
            return -1;
        }

        for (int i = 0; i < 4; i++) {
            targetPoint[i] = target.charAt(i) - 48;
        }

        int[] initPoint = new int[]{0, 0, 0, 0};
        queue1.offer(initPoint);
        setCheck(initPoint, 1);
        Queue<int[]> queue = queue1;
        nowOne = true;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int[] point = queue.poll();

                if (arrayEquals(point, targetPoint)) {
                    return count;
                }

                goFrom(point, nowOne ? queue2 : queue1);
            }

            nowOne = !nowOne;
            queue = nowOne ? queue1 : queue2;
            count++;
        }

        return -1;
    }
    private void goFrom(int[] point, Queue<int[]> queue) {
        int[] newPoint = Arrays.copyOf(point, 4);
        for (int i = 0; i < 4; i++) {
            newPoint[i] = lastOne(newPoint[i]);
            if (getCheck(newPoint) == 0) {
                int[] addPoint = Arrays.copyOf(newPoint, 4);
                queue.offer(addPoint);
                setCheck(addPoint, 1);
            }
            newPoint[i] = nextOne(newPoint[i]);
            newPoint[i] = nextOne(newPoint[i]);
            if (getCheck(newPoint) == 0) {
                int[] addPoint = Arrays.copyOf(newPoint, 4);
                queue.offer(addPoint);
                setCheck(addPoint, 1);
            }
            newPoint[i] = lastOne(newPoint[i]);
        }
    }
    private boolean arrayEquals(int[] point1, int[] point2) {
        if (point1.length != point2.length) {
            return false;
        }
        for (int i = 0; i < point1.length; i++) {
            if (point1[i] != point2[i]) {
                return false;
            }
        }
        return true;
    }
    private void setCheck(int[] point, int val) {
        check[point[0]][point[1]][point[2]][point[3]] = val;
    }
    private int getCheck(int[] point) {
        return check[point[0]][point[1]][point[2]][point[3]];
    }
    private int lastOne(int x) {
        return (x + 10 - 1) % 10;
    }
    private int nextOne(int x) {
        return (x + 1) % 10;
    }

    /**
     * 完全平方数
     */
    private int[] results;
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        results = new int[n];

        return myNumSquares(n);
    }
    private int myNumSquares(int n) {
        if (results[n-1] != 0) {
            return results[n-1];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            if (i * i < n) {
                result = Integer.min(result, myNumSquares(n - i * i) + 1);
            }
            else {
                result = 1;
                break;
            }
        }

        results[n-1] = result;
        return result;
    }
}
