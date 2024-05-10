package com.wen.repository.solution0200To0299;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution0210To0219Test {

    Solution0210To0219 solution = new Solution0210To0219();

    @Test
    public void findOrder() {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0}
        };
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }

    @Test
    public void shortestPalindrome() {
        int count = 20;
        String s = "a";
        while (count > 0) {
            s += s;
            count--;
        }
        System.out.println(solution.shortestPalindrome(s));
    }

    @Test
    public void getSkyline() {
        int[][] buildings = {
                {2, 4, 70},
                {3, 8, 30},
                {6, 100, 41},
                {7, 15, 70},
                {10, 30, 102},
                {15, 25, 76},
                {60, 80, 91},
                {70, 90, 72},
                {85, 120, 59}
        };
        System.out.println(solution.getSkyline(buildings));
    }

    @Test
    public void containsNearbyDuplicate1() {
        int[] nums = {1,2,3,1};
        int k = 3;

        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
    @Test
    public void containsNearbyDuplicate2() {
        int[] nums = {1,0,1,1};
        int k = 1;

        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
    @Test
    public void containsNearbyDuplicate3() {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}