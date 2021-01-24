package com.wen.repository.solution1300To1399;

import com.wen.util.UnionFind;

public class Solution1310To1319 {

    /**
     * 1319. Number of Operations to Make Network Connected
     *
     * 1 <= n <= 10^5
     * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
     * connections[i].length == 2
     * 0 <= connections[i][0], connections[i][1] < n
     * connections[i][0] != connections[i][1]
     * There are no repeated connections.
     * No two computers are connected by more than one cable.
     */
    public int makeConnected(int n, int[][] connections) {
        if (n <= 2) {
            return 0;
        }
        int len = connections.length;
        if (len < n - 1) {
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);
        int unionCount = n;
        for (int[] cable: connections) {
            int a = cable[0], b = cable[1];
            if (unionFind.find(a) != unionFind.find(b)) {
                unionFind.union(a, b);
                unionCount--;
            }
        }
        return unionCount-1;
    }
}
