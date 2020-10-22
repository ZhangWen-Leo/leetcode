package com.wen.explore.topInterviewQuestionsMedium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortAndSearchTest {

    private SortAndSearch sortAndSearch = new SortAndSearch();

    @Test
    public void sortColors() {
        int[] a = {0,0,0,0};
//        sortAndSearch.sortColors(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void topKFrequent() {
        int[] a = {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        System.out.println(Arrays.toString(sortAndSearch.topKFrequent(a, 6)));
    }

    @Test
    public void findKthLargest() {
        int[] a = {3,2,1,5,6,4};
        System.out.println(sortAndSearch.findKthLargest(a, 2));
    }

    @Test
    public void findPeakElement() {
        int[] a = {2,1};
        System.out.println(sortAndSearch.findPeakElement(a));
    }

    @Test
    public void searchMatrix() {
        int[][] a = {
                {1,3,5}
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
        };
        System.out.println(sortAndSearch.searchMatrix(a, -1));
    }
}