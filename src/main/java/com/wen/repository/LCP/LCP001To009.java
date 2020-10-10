package com.wen.repository.LCP;

public class LCP001To009 {

    /**
     * LCP 02. 分式化简
     */
    public int[] fraction(int[] cont) {
        int numerator, denominator, temp;

        numerator = 1;
        denominator = cont[cont.length-1];

        for (int i = cont.length - 2; i >= 0; i--) {
            numerator += cont[i] * denominator;

            // 交换分子分母
            temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        return new int[]{denominator, numerator};
    }
}
