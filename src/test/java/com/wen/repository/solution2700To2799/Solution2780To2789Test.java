package com.wen.repository.solution2700To2799;

import org.junit.Assert;
import org.junit.Test;

public class Solution2780To2789Test {
	Solution2780To2789 solution = new Solution2780To2789();

	@Test
	public void isGood() {
		Assert.assertFalse(solution.isGood(new int[]{2,1,3}));
		Assert.assertTrue(solution.isGood(new int[]{1,3,3,2}));
		Assert.assertTrue(solution.isGood(new int[]{1,1}));
		Assert.assertFalse(solution.isGood(new int[]{3,4,4,1,2,1}));
	}

	@Test
	public void maxScore() {
		Assert.assertEquals(13, solution.maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
		Assert.assertEquals(20, solution.maxScore(new int[]{2, 4, 6, 8}, 3));
		Assert.assertEquals(470, solution.maxScore(new int[]{8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79}, 74));
	}
}
