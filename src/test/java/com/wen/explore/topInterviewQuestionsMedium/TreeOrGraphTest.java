package com.wen.explore.topInterviewQuestionsMedium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class TreeOrGraphTest {

    TreeOrGraph treeOrGraph = new TreeOrGraph();

    @Test
    public void inorderTraversal() {
    }

    @Test
    public void zigzagLevelOrder() {
    }

    @Test
    public void buildTree() {
        int[] a = {3, 9, 3, 15, 7};
        int[] b = {3, 9, 3, 15, 7};
        System.out.println(treeOrGraph.buildTree(a, b));
    }

    @Test
    public void numIslands() {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(treeOrGraph.numIslands(grid));
    }

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
    }
}