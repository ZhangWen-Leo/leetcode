package com.wen.repository.solution2800To2899;

import org.junit.Assert;
import org.junit.Test;

public class Solution2810To2819Test {
	Solution2810To2819 solution = new Solution2810To2819();

	@Test
	public void findMaximumElegance() {
		Assert.assertEquals(17, solution.findMaximumElegance(new int[][]{
			{3, 2},
			{5, 1},
			{10, 1},
		}, 2));
		Assert.assertEquals(19, solution.findMaximumElegance(new int[][]{
			{3, 1},
			{3, 1},
			{2, 2},
			{5, 3},
		}, 3));
		Assert.assertEquals(7, solution.findMaximumElegance(new int[][]{
			{1, 1},
			{2, 1},
			{3, 1},
		}, 3));
	}
}
