package com.wen.repository.solution1500To1599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1550To1559 {

    /**
     * 1553. Minimum Number of Days to Eat N Oranges
     * <p>
     * 下面这个解法过不了
     */
    private final HashMap<Integer, Integer> resultMap = new HashMap<>();

    public int minDays(int n) {
        if (this.resultMap.get(n) != null) {
            return this.resultMap.get(n);
        } else {
            if (n == 1) {
                resultMap.put(1, 1);
                return 1;
            } else {
                int result = this.minDays(n - 1);
                if (n % 2 == 0) {
                    result = Math.min(result, this.minDays(n / 2));
                }
                if (n % 3 == 0) {
                    result = Math.min(result, this.minDays(n / 3));
                }
                this.resultMap.put(n, result + 1);
                return result + 1;
            }
        }
    }

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
