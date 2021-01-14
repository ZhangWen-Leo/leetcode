package com.wen.repository.solution0100To0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution0180To0189 {

    /**
     * 180-185. SQL
     */

    /**
     * 186. Reverse Words in a String II
     */
    public void reverseWords(char[] s) {
        reverseWords(s, 0, s.length);

        for (int start = 0; start < s.length; ) {
            int end = start;
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverseWords(s, start, end);
            start = end+1;
        }
    }
    private void reverseWords(char[] s, int start, int end) {
        end--;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 187. Repeated DNA Sequences
     *
     * 20ms 65.97%
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hashSet = new HashSet<>(), result = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String subS = s.substring(i, i+10);
            if (hashSet.contains(subS)) {
                result.add(subS);
            }
            else {
                hashSet.add(subS);
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 188. Best Time to Buy and Sell Stock IV
     *
     * 482ms    5.11%
     */
    private int[][] profitDp;
    private int[][] minPriceDp;
    private int[] prices;
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len == 0) {
            return 0;
        }
        profitDp = new int[k][len];
        minPriceDp = new int[len][len];
        this.prices = prices;

        profitDp[0][len-1] = 0;
        int max = prices[len-1];
        for (int i = len-2; i >= 0; i--) {
            profitDp[0][i] = Math.max(profitDp[0][i+1], max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        for (int i = 1; i < k; i++) {
            Arrays.fill(profitDp[i], -1);
        }

        // 初始化minPriceDp
        for (int i = 0; i < len; i++) {
            minPriceDp[i][i] = prices[i];
        }
        for (int i = 1; i < len; i++) {
            int x = 0, y = i;
            while (y < len) {
                minPriceDp[x][y] = Math.min(minPriceDp[x][y-1], minPriceDp[x+1][y]);
                x++;
                y++;
            }
        }

        return getProfit(k-1, 0);
    }
    private int getProfit(int time, int day) {
        if (time < 0 || day >= prices.length) {
            return 0;
        }
        if (profitDp[time][day] < 0) {
            for (int i = day; i < prices.length; i++) {
                profitDp[time][day] = Math.max(
                        prices[i] - minPriceDp[day][i] + getProfit(time-1, i+1),
                        profitDp[time][day]
                );
            }
        }
        return profitDp[time][day];
    }

    /**
     * 189. Rotate Array
     */
    public void rotate(int[] nums, int k) {
        int start = -1;
        for (int i = 0, j = -1, temp = nums[i]; i < nums.length; i++) {
            if (j == start) {
                j++;
                start++;
                temp = nums[j];
            }
            j = (j+k) % nums.length;
            temp += nums[j];
            nums[j] = temp - nums[j];
            temp -= nums[j];
        }
    }
}
