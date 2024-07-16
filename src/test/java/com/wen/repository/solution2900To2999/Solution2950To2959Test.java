package com.wen.repository.solution2900To2999;


import org.junit.Assert;
import org.junit.Test;


public class Solution2950To2959Test {
	Solution2950To2959 solution = new Solution2950To2959();

	@Test
	public void findPeaks() {
		Assert.assertArrayEquals(new Integer[]{}, solution.findPeaks(new int[]{2, 4, 4}).toArray());
		Assert.assertArrayEquals(new Integer[]{1, 3}, solution.findPeaks(new int[]{1, 4, 3, 8, 5}).toArray());
	}

	@Test
	public void findIntersectionValues() {
		Assert.assertArrayEquals(new int[]{2, 1},
			solution.findIntersectionValues(new int[]{2, 3, 2}, new int[]{1, 2}));
		Assert.assertArrayEquals(new int[]{3, 4},
			solution.findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}));
		Assert.assertArrayEquals(new int[]{0, 0},
			solution.findIntersectionValues(new int[]{3, 4, 2, 3}, new int[]{1, 5}));
	}
}
