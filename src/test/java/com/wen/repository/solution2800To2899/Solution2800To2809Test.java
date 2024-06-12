package com.wen.repository.solution2800To2899;

import org.junit.Assert;
import org.junit.Test;

public class Solution2800To2809Test {
	Solution2800To2809 solution = new Solution2800To2809();

	@Test
	public void accountBalanceAfterPurchase() {
		Assert.assertEquals(90, solution.accountBalanceAfterPurchase(9));
		Assert.assertEquals(80, solution.accountBalanceAfterPurchase(15));
		Assert.assertEquals(80, solution.accountBalanceAfterPurchase(24));
		Assert.assertEquals(0, solution.accountBalanceAfterPurchase(99));
		Assert.assertEquals(20, solution.accountBalanceAfterPurchase(75));
	}
}
