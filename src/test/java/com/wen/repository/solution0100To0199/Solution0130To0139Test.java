package com.wen.repository.solution0100To0199;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0130To0139Test {

    Solution0130To0139 solution = new Solution0130To0139();

    @Test
    public void candy() {
        int[] ratings = {
                1,3,2,2,1
        };
        System.out.println(solution.candy(ratings));
    }

    @Test
    public void canCompleteCircuit() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}