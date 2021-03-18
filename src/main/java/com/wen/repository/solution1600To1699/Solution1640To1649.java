package com.wen.repository.solution1600To1699;

public class Solution1640To1649 {

    /**
     * 1641. Count Sorted Vowel Strings
     *
     * a, e, i, o, u是元音字母序列
     *
     * 1 <= n <= 50
     *
     * @param n 给定长度n
     * @return  能组成长度为n的元音按序排列的字符串数目
     */
    public int countVowelStrings(int n) {
        int[] res = {1, 1, 1, 1, 1};

        for (int i = 1; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                res[j] += res[j+1];
            }
        }

        return getSum(res);
    }
    private int getSum(int[] res) {
        return getSum(res, 0);
    }
    private int getSum(int[] res, int start) {
        int sum = 0;
        for (int i = start; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }
}
