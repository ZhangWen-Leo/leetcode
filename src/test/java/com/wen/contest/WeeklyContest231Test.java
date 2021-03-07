package com.wen.contest;

import com.wen.util.WenList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WeeklyContest231Test {

    WeeklyContest231 solution = new WeeklyContest231();

    @Test
    public void countRestrictedPaths() {
        int n = 6;
        int[][] edges = {
                {2, 4, 5},
                {3, 4, 2},
                {2, 1, 3},
                {3, 1, 3},
                {4, 6, 5},
                {5, 1, 9},
                {1, 4, 3},
                {2, 6, 5},
                {5, 6, 5},
                {5, 3, 8},
                {1, 6, 6},
                {3, 2, 8},
                {5, 2, 8}
        };

        System.out.println(solution.countRestrictedPaths(n, edges));;
    }
}