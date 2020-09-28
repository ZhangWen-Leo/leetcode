package com.wen.explore.topInterviewQuestionsMedium;

import java.util.ArrayList;
import java.util.List;

public class MathQuestion {
    /**
     * 快乐数
     */
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        int i = sumOfSquares(n);
        while (i != 1 && !list.contains(i)) {
            list.add(i);
            i = sumOfSquares(i);
        }
        if (i == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    private int sumOfSquares(int n) {
        int result = 0, i;
        do {
            i = n % 10;
            result += i * i;
        } while ((n /= 10) != 0);
        return result;
    }

    /**
     * 阶乘后的零
     */
    public int trailingZeroes(int n) {
        int count = 0;
        long i = 5;
        while (n >= i) {
            count += n / i;
            i *= 5;
        }

        return count;
    }

    /**
     * Excel表列序号
     */
    public int titleToNumber(String s) {
        int length = s.length(), result = 0;
        for (int i = 0; i < length; i++) {
            result += (s.charAt(i) - 64) * Math.pow(26, length - i - 1);
        }
        return result;
    }

    /**
     * Pow(x, n)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 2) {
            return x * x;
        }

        if (n % 2 == 0) {
            return myPow(myPow(x, n/2), 2);
        }
        else {
            return myPow(x, n-1) * x;
        }
    }

    /**
     * x 的平方根
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1, end = x < 46341 ? x : 46341, i;
        while (start < end-1) {
            i = (start + end) / 2;
            int y = i * i;
            if (y > x) {
                end = i;
            }
            else if (y < x) {
                start = i;
            }
            else {
                return i;
            }
        }
        return (start + end) / 2;
    }

    /**
     * 两数相除
     */
    private List<long[]> divideList = new ArrayList<>();
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0);
        long newDividend = dividend >= 0 ? dividend : - (long) dividend;
        long newDivisor = divisor >= 0 ? divisor : - (long) divisor;
        long result;

        if (newDividend < newDivisor) {
            return 0;
        }
        if (newDividend == newDivisor) {
            return negative ? -1 : 1;
        }

        if (divideList.size() == 0) {
            long[] a = {1, newDivisor};
            divideList.add(a);
        }

        long[] node = divideList.get(divideList.size()-1);
        while (node[1] <= newDividend) {
            long[] newNode = new long[2];
            newNode[0] = node[0] + node[0];
            newNode[1] = node[1] + node[1];
            divideList.add(newNode);
            node = divideList.get(divideList.size()-1);
        }

        int i = 0;
        while (i < divideList.size()) {
            if (divideList.get(i)[1] > newDividend) {
                break;
            }
            i++;
        }

        node = divideList.get(i-1);
        result = node[0] + divide((int) (newDividend - node[1]), (int) newDivisor);

        if (negative) {
            if (-result < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) -result;
        }
        else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) result;
        }
    }

    /**
     * 分数到小数
     */
    List<Long> decimalList = new ArrayList<>();
    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = (numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0);
        long newNumerator = numerator >= 0 ? numerator : - (long) numerator;
        long newDenominator = denominator >= 0 ? denominator : - (long) denominator;
        String result = "";
        result += (negative
                        ? (newNumerator % newDenominator == 0 && newNumerator / newDenominator == 0 ? "" : "-")
                        : ""
        ) + newNumerator / newDenominator;
        long left = newNumerator % newDenominator;
        if (left != 0) {
            result += ".";
            do {
                decimalList.add(left);
                left *= 10;
                result += String.valueOf(left / newDenominator);
                left %= newDenominator;
            } while (left != 0 && !decimalList.contains(left));

            if (decimalList.contains(left)) {
                int index_start = decimalList.indexOf(left);
                String loopString = result.substring(
                        result.length() - (decimalList.size()-index_start)
                );
                result = result.substring(0, result.length() - (decimalList.size()-index_start));
                result += "(" + loopString + ")";
            }
        }

        return result;
    }
}
