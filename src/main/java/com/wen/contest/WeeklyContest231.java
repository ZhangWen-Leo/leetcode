package com.wen.contest;

import java.util.*;

public class WeeklyContest231 {

    /**
     * 5697. 检查二进制字符串字段
     */
    public boolean checkOnesSegment(String s) {
        boolean pre = true;
        for (int i = 1; i < s.length(); i++) {
            if (pre) {
                if (s.charAt(i) != '1') {
                    pre = false;
                }
            }
            else {
                if (s.charAt(i) == '1') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 5698. 构成特定和需要添加的最少元素
     */
    public int minElements(int[] nums, int limit, int goal) {
        int len = nums.length;
        long sum = 0;

        for (int i = 0; i < len;i++) {
            sum += nums[i];
        }

        if (sum != goal) {
            long sub;
            sub = Math.abs(sum - goal);
            if (sub % limit == 0) {
                return (int) (sub / limit);
            }
            else {
                return (int) (sub / limit) + 1;
            }
        }
        else {
            return 0;
        }
    }

    /**
     * 5699. 从第一个节点出发到最后一个节点的受限路径数
     *
     * 未通过
     */
    private int[] resDp;
    private List<int[]>[] edges;
    private int[] distanceToLastNode;
    private static int mod = (int) Math.pow(10, 9) + 7;
    public int countRestrictedPaths(int n, int[][] edges) {
        if (n == 1) {
            return 0;
        }
        this.edges = new List[n];
        distanceToLastNode = new int[n];
        for (int i = 0; i < n; i++) {
            this.edges[i] = new LinkedList<>();
        }
        Arrays.fill(distanceToLastNode, 1000000);

        for (int[] edge: edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            this.edges[a].add(new int[]{b, edge[2]});
            this.edges[b].add(new int[]{b, edge[2]});
        }

        getMinDistance();

        resDp = new int[n];
        Arrays.fill(resDp, -1);
        resDp[n-1] = 1;

        return getRes(0);
    }
    private int getRes(int i) {
        if (resDp[i] >= 0) {
            return resDp[i];
        }
        resDp[i] = 0;
        for (int[] edge: edges[i]) {
            if (distanceToLastNode[i] > distanceToLastNode[edge[0]]) {
                resDp[i] = (resDp[i] + getRes(edge[0])) % mod;
            }
        }
        return resDp[i];
    }
    private void getMinDistance() {
        int len = edges.length;
        distanceToLastNode[len-1] = 0;

        HashSet<Integer> set = new HashSet<>();
        set.add(len-1);

        int last = len - 1;
        while (set.size() < len) {
            int minDis = Integer.MAX_VALUE, minIndex = last;
            for (int[] edge: edges[last]) {
                if (!set.contains(edge[0])) {
                    distanceToLastNode[edge[0]] = Math.min(
                            distanceToLastNode[edge[0]], distanceToLastNode[last] + edge[1]
                    );
                }
            }
            for (int i = 0; i < len; i++) {
                if (!set.contains(i) && distanceToLastNode[i] < minDis) {
                    minDis = distanceToLastNode[i];
                    minIndex = i;
                }
            }

            set.add(minIndex);
            last = minIndex;
        }
    }
}
