package com.wen.explore.topInterviewQuestionsMedium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DynamicProgramingTest {

    DynamicPrograming dynamicPrograming = new DynamicPrograming();

    @Test
    public void coinChange() {
        int[] a = {186,419,83,408};
        int amount = 6249;
        System.out.println(dynamicPrograming.coinChange(a, amount));
    }

    @Test
    public void lengthOfLIS() {
        int[] a = {10,20,1,30,40,2,50,3,60,70,4,5,6};
        System.out.println(dynamicPrograming.lengthOfLIS(a));
    }

    @Test
    public void test() {

    }
}