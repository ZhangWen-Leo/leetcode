package com.wen.repository.solution2700To2799;

public class Solution2780To2789 {
	/**
	 * 2786. Visit Array Positions to Maximize Score
	 *
	 * <p>2 <= nums.length <= 10<sup>5</sup></p>
	 * <p>1 <= nums[i], x <= 10<sup>6</sup></p>
	 */
	public long maxScore(int[] nums, int x) {
		long oddMax = 0;
		long evenMax = 0;
		long cur = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			if (num % 2 == 0) {
				cur = Math.max(evenMax + num, oddMax + num - x);
				evenMax = Math.max(evenMax, cur);
			} else {
				cur = Math.max(oddMax + num, evenMax + num - x);
				oddMax = Math.max(oddMax, cur);
			}
		}
		return cur;
	}
}
