package com.wen.explore.topInterviewQuestionsMedium.design;

import java.util.Arrays;
import java.util.Random;

public class RandomizedSet {

    int[] nums;
    int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new int[10];
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexOf(val) >= 0) {
            return false;
        }

        ensureCapacity(size + 1);
        nums[size++] = val;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = indexOf(val);
        if (index < 0) {
            return false;
        }

        int moveLength = size - 1 - index;
        if (moveLength == 0) {
            size--;
        }
        else if (moveLength > 0) {
            System.arraycopy(nums, index+1, nums, index, moveLength);
            size--;
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return nums[random.nextInt(size)];
    }

    public int indexOf(int val) {
        for (int i = 0; i < size; i++) {
            if (val == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > nums.length) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = nums.length;
        int newCapacity = oldCapacity;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        nums = Arrays.copyOf(nums, newCapacity);
    }

    @Override
    public String toString() {
        return Arrays.toString(nums) + " size: " + size;
    }
}
