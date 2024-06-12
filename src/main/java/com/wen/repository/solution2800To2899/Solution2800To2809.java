package com.wen.repository.solution2800To2899;

public class Solution2800To2809 {
	/**
	 * 2806. Account Balance After Rounded Purchase
	 *
	 * <p>0 <= purchaseAmount <= 100</p>
	 */
	public int accountBalanceAfterPurchase(int purchaseAmount) {
		return 100 - 10 * (purchaseAmount / 10 + (purchaseAmount % 10 >= 5 ? 1 : 0));
	}
}
