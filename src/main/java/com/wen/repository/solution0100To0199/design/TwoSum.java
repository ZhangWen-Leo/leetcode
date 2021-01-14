package com.wen.repository.solution0100To0199.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

    List<Integer> nums;

    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> need = new HashSet<>();
        for (int num : nums) {
            if (need.contains(num)) {
                return true;
            }
            need.add(value-num);
        }
        return false;
    }
}
