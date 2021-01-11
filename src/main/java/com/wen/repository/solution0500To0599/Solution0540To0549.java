package com.wen.repository.solution0500To0599;

public class Solution0540To0549 {

    /**
     * 547. Number of Provinces
     */
    private boolean[] checked;
    private int[][] isConnected;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        checked = new boolean[n];
        this.isConnected = isConnected;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                count++;
                check(i);
            }
        }
        return count;
    }
    private void check(int index) {
        checked[index] = true;
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i] && isConnected[index][i] == 1) {
                check(i);
            }
        }
    }
}
