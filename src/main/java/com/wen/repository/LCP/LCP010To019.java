package com.wen.repository.LCP;

import java.util.ArrayList;
import java.util.List;

public class LCP010To019 {

    /**
     * 19. 秋叶收藏集
     */
    public int minimumOperations(String leaves) {
        int[][] f = new int[leaves.length()][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < leaves.length(); i++) {
            boolean isRed = leaves.charAt(i) == 'r';

            f[i][0] = f[i - 1][0] + (isRed ? 0 : 1);
            f[i][1] = Integer.min(f[i - 1][0], f[i-1][1]) + (isRed ? 1 : 0);
            if (i >= 2) {
                f[i][2] = Integer.min(f[i - 1][1], f[i - 1][2]) + (isRed ? 0 : 1);
            }
        }

        return f[leaves.length() - 1][2];
    }
}
