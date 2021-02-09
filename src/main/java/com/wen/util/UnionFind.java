package com.wen.util;

public class UnionFind {
    private int[] parent;
    private int numOfUnion;

    public UnionFind(int n) {
        parent = new int[n];
        numOfUnion = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        if (find(x) != find(y)) {
            parent[find(x)] = find(y);
            numOfUnion--;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int getNumOfUnion() {
        return numOfUnion;
    }
}
