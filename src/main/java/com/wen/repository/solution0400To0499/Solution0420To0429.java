package com.wen.repository.solution0400To0499;


public class Solution0420To0429 {

    /**
     * 424. Longest Repeating Character Replacement
     *
     * 10ms 25.33%
     *
     * 优化方向：窗口大小是只扩充而不需要缩减的，所以，只需要判断最大的值有没有扩充，最大值变大就意味着
     * 能接受的窗口大小也会变大，最大值没有变化即可保持原窗口大小右移
     */
    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0, right = 0;
        int[] chars = new int[26];
        int len = s.length();
        while (right < len) {
            chars[s.charAt(right++)-'A']++;
            if (right-left-getMaxInArray(chars) > k) {
                chars[s.charAt(left++)-'A']--;
            }
            res = right-left;
        }

        return res;
    }
    private int getMaxInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            max = Math.max(max, num);
        }

        return max;
    }
}
