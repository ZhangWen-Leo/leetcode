package com.wen.repository.solution2000To2099;


public class Solution2020To2029 {
	/**
	 * 2028. Find Missing Observations
	 *
	 * <p>m == rolls.length</p>
	 * <p>1 <= n, m <= 10<sup>5</sup></p>
	 * <p>1 <= rolls[i], mean <= 6</p>
	 */
	public int[] missingRolls(int[] rolls, int mean, int n) {
		int sum = mean * (rolls.length + n);
		int sumOfRolls = 0;
		for (int roll : rolls) {
			sumOfRolls += roll;
		}

		int sumOfResult = sum - sumOfRolls;
		if (sumOfResult < n || sumOfResult > 6 * n) {
			return new int[]{};
		}
		int[] result = new int[n];
		int i = 0, leftSum = sumOfResult;
		while (i < n && leftSum - 1 <= 6 * (n - i - 1)) {
			result[i++] = 1;
			leftSum -= 1;
		}
		while (i < n && leftSum - 6 >= n - i - 1) {
			result[i++] = 6;
			leftSum -= 6;
		}
		if (i < n && leftSum > 0) {
			result[i] = leftSum;
		}
		return result;
	}
}
