package com.wen.repository.solution2000To2099;


import org.junit.Assert;
import org.junit.Test;

public class Solution2020To2029Test {
	Solution2020To2029 solution = new Solution2020To2029();

	@Test
	public void missingRolls() {
		Assert.assertArrayEquals(new int[]{6, 6}, solution.missingRolls(new int[]{3, 2, 4, 3}, 4, 2));
		Assert.assertArrayEquals(new int[]{1, 1, 1, 6}, solution.missingRolls(new int[]{1, 5, 6}, 3, 4));
		Assert.assertArrayEquals(new int[]{}, solution.missingRolls(new int[]{1, 2, 3, 4}, 6, 4));
	}
}
