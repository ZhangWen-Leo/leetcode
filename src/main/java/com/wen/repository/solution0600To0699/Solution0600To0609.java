package com.wen.repository.solution0600To0699;

import java.util.ArrayList;
import java.util.List;

public class Solution0600To0609 {

    /**
     * 605. Can Place Flowers
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start = 0, count = 0;
        while (start < flowerbed.length) {
            if (flowerbed[start] == 1) {
                while (start < flowerbed.length && flowerbed[start] == 1) {
                    start++;
                }
                start++;
            }
            else if (start < flowerbed.length - 1 && flowerbed[start+1] == 1) {
                start++;
            }
            else {
                int end = start;
                while (end < flowerbed.length-1 && flowerbed[end+1] == 0) {
                    end++;
                }
                if (end == flowerbed.length-1) {
                    end++;
                }
                count += (end - start + 1) / 2;
                start = end;
            }
        }

        return count >= n;
    }
}
