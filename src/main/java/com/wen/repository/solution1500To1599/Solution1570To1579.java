package com.wen.repository.solution1500To1599;

import com.wen.util.UnionFind;

public class Solution1570To1579 {

    /**
     * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUnion = new UnionFind(n);
        UnionFind bobUnion = new UnionFind(n);
        int len = edges.length;

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (edges[i][0] == 3) {
                int a = edges[i][1] - 1, b = edges[i][2] -1 ;
                if (aliceUnion.find(a) != aliceUnion.find(b)) {
                    aliceUnion.union(a, b);
                    bobUnion.union(a, b);
                }
                else {
                    count++;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (edges[i][0] == 1) {
                int a = edges[i][1] - 1, b = edges[i][2] -1 ;
                if (aliceUnion.find(a) != aliceUnion.find(b)) {
                    aliceUnion.union(a, b);
                }
                else {
                    count++;
                }
            }
            else if (edges[i][0] == 2) {
                int a = edges[i][1] - 1, b = edges[i][2] -1 ;
                if (bobUnion.find(a) != bobUnion.find(b)) {
                    bobUnion.union(a, b);
                }
                else {
                    count++;
                }
            }
        }

        return aliceUnion.getNumOfUnion() == 1 && bobUnion.getNumOfUnion() == 1
                ? count : -1;
    }
}
