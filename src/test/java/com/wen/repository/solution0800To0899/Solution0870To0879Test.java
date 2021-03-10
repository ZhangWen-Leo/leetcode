package com.wen.repository.solution0800To0899;

import com.wen.util.WenList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution0870To0879Test {

    Solution0870To0879 solution = new Solution0870To0879();

    @Test
    public void profitableSchemes() {
        int n = 95;
        int minProfit = 53;
        int[] group = WenList.getArrayFromList(
                (List<Integer>) WenList.getListFromString(
                        "[82,7,18,34,1,3,83,56,50,34,39,38,76,92,71,2,6," +
                                "74,1,82,22,73,88,98,6,71,6,26,100,75,57,88," +
                                "43,16,22,89,7,9,78,97,22,87,34,81,74,56,49,94," +
                                "87,71,59,6,20,66,64,37,2,42,30,87,73,16,39,87,28," +
                                "9,95,78,43,59,87,78,2,93,7,22,21,59,68,67,65,63,78,20,82,35,86]"
                )
        );
        int[] profit = WenList.getArrayFromList(
                (List<Integer>) WenList.getListFromString(
                        "[45,57,38,64,52,92,31,57,31,52,3,12," +
                                "93,8,11,60,55,92,42,27,40,10,77," +
                                "53,8,34,87,39,8,35,28,70,32,97,88,54," +
                                "82,54,54,10,78,23,82,52,10,49,8,36,9,52," +
                                "81,26,5,2,30,39,89,62,39,100,67,33,86,22,49," +
                                "15,94,59,47,41,45,17,99,87,77,48,22,77,82,85,97,66,3,38,49,60,66]"));
        System.out.println(solution.profitableSchemes(n, minProfit, group, profit));
        return;
    }
}