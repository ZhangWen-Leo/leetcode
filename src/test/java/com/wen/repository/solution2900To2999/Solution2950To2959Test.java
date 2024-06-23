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
}
