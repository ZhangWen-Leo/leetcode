package com.wen.repository.solution1500To1599;

import java.util.ArrayList;
import java.util.List;

public class Solution1550To1559 {

    /**
     * 1557. Minimum Number of Vertices to Reach All Nodes
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] check = new boolean[n];
        List<Integer> result = new ArrayList<>();

        for (List<Integer> edge :
                edges) {
            check[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
