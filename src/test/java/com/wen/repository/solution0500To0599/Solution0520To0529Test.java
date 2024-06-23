package com.wen.repository.solution0500To0599;

import org.junit.Assert;
import org.junit.Test;

public class Solution0520To0529Test {
	Solution0520To0529 solution = new Solution0520To0529();

	@Test
	public void detectCapitalUse() {
		Assert.assertTrue(solution.detectCapitalUse("USA"));
		Assert.assertTrue(solution.detectCapitalUse("The"));
		Assert.assertTrue(solution.detectCapitalUse("question"));
		Assert.assertTrue(solution.detectCapitalUse("leetcode"));
		Assert.assertFalse(solution.detectCapitalUse("leetCode"));
		Assert.assertFalse(solution.detectCapitalUse("LEETcode"));
		Assert.assertFalse(solution.detectCapitalUse("FlaG"));
	}
}
