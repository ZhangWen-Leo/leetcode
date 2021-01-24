package com.wen.repository.solution0600To0699;

import com.wen.util.UnionFind;

public class Solution0680To0689 {

    /**
     * 684. Redundant Connection
     */
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            int a = edges[i][0] - 1, b = edges[i][1] - 1;
            if (unionFind.find(a) == unionFind.find(b)) {
                return edges[i];
            }
            else {
                unionFind.union(a, b);
            }
        }

        return null;
    }
}
