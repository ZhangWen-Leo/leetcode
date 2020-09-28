package com.wen.explore.topInterviewQuestionsMedium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathQuestionTest {

    private MathQuestion math = new MathQuestion();

    @Test
    public void isHappy() {
        System.out.println(math.isHappy(19));
    }

    @Test
    public void trailingZeroes() {
        System.out.println(math.trailingZeroes(375));
    }

    @Test
    public void titleToNumber() {
        System.out.println(math.titleToNumber("ZY"));
    }

    @Test
    public void mySqrt() {
        System.out.println(math.mySqrt(2147483647));
    }

    @Test
    public void divide() {
        System.out.println(math.divide(-1, 1));
    }

    @Test
    public void fractionToDecimal() {
        System.out.println(math.fractionToDecimal(-2147483648, 1));
    }

    @Test
    public void test() {
    }
}