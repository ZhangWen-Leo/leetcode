package com.wen.repository.solution0100To0199;

import java.util.ArrayList;
import java.util.List;

public class Solution0130To0139 {

    /**
     * 134. Gas Station
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        List<Integer> surplus = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            surplus.add(gas[i] - cost[i]);
        }

        return calculateNeed(surplus);
    }
    private int calculateNeed(List<Integer> surplus) {
        if (surplus.size() == 1) {
            return surplus.get(0) >= 0 ? 0 : -1;
        }
        List<Integer> compress = new ArrayList<>();
        List<Integer> headIndex = new ArrayList<>();
        int length = surplus.size();

        int start = 0;
        while (start < length && surplus.get(start) <= 0) {
            start++;
        }
        if (start == length) {
            return -1;
        }
        headIndex.add(start);

        int i = start;
        while (i < length) {
            while (i < length && surplus.get(i) >= 0) {
                i++;
            }
            while (i < length && surplus.get(i) <= 0) {
                i++;
            }if (i < length) {
                headIndex.add(i);
            }
        }

        for (int j = 0; j < headIndex.size(); j++) {
            int current = 0;
            int k = headIndex.get(j);
            do {
                current += surplus.get(k);
                k = (k + 1) % length;
            } while (k != headIndex.get((j+1) % headIndex.size()));
            compress.add(current);
        }

        int result = calculateNeed(compress);
        if (result >= 0) {
            return headIndex.get(result);
        }
        else {
            return -1;
        }
    }

    /**
     * 135. Candy
     */
    private int[] ratings;
    private int[] candies;
    public int candy(int[] ratings) {
        this.ratings = ratings;
        candies = new int[ratings.length];

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += candy(i);
        }

        return count;
    }
    private int candy(int index) {
        if (candies[index] > 0) {
            return candies[index];
        }

        boolean smallThanLeft = (index == 0 || ratings[index] <= ratings[index - 1]),
                smallThanRight = (index == ratings.length - 1 || ratings[index] <= ratings[index + 1]),
                biggerThanLeft = !smallThanLeft,
                biggerThanRight = !smallThanRight;
        if (smallThanLeft && smallThanRight) {
            candies[index] = 1;
        }
        else if (biggerThanLeft && biggerThanRight) {
            candies[index] = Integer.max(candy(index - 1), candy(index + 1)) + 1;
        }
        else if (biggerThanLeft) {
            candies[index] = candy(index - 1) + 1;
        }
        else {
            candies[index] = candy(index + 1) + 1;
        }

        return candies[index];
    }

    /**
     * 136. Single Number
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears only once.
     */
    public int singleNumber(int[] nums) {
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }
}
