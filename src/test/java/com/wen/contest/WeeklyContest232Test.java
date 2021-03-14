package com.wen.contest;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeeklyContest232Test {

    WeeklyContest232 solution = new WeeklyContest232();


    @Test
    public void maxAverageRatio() {
        int[][] classes = {
                {2,4},
                {3,9},
                {4,5},
                {2,10}
        };
        System.out.println(solution.maxAverageRatio(classes, 4));
    }

    @Test
    public void maximumScore() {
        int[] nums = {5,5,4,5,4,1,1,1};
        System.out.println(solution.maximumScore(nums, 0));
    }
}