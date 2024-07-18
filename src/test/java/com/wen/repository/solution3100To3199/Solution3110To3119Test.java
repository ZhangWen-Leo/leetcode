package com.wen.repository.solution3100To3199;

import org.junit.Assert;
import org.junit.Test;

public class Solution3110To3119Test {
	Solution3110To3119 solution = new Solution3110To3119();

	@Test
	public void minimumTime() {
		Assert.assertArrayEquals(new int[] { 0, 10, 8, 3, -1, -1, -1, 11 }, solution.minimumTime(8, new int[][] {
				{ 0, 3, 3 },
				{ 2, 0, 8 },
				{ 1, 3, 7 },
				{ 5, 7, 2 },
				{ 7, 3, 8 },
				{ 5, 0, 7 }
		}, new int[] { 19, 18, 14, 20, 19, 4, 19, 18 }));
		Assert.assertArrayEquals(new int[] { 0, -1, -1, -1, -1, -1, -1 }, solution.minimumTime(7, new int[][] {
				{ 1, 4, 3 },
				{ 3, 4, 2 },
				{ 2, 5, 5 },
				{ 3, 3, 10 }
		}, new int[] { 10, 1, 13, 1, 7, 1, 19 }));
		Assert.assertArrayEquals(new int[] { 0, -1, 4 }, solution.minimumTime(3, new int[][] {
				{ 0, 1, 2 },
				{ 1, 2, 1 },
				{ 0, 2, 4 }
		}, new int[] { 1, 1, 5 }));
		Assert.assertArrayEquals(new int[] { 0, 2, 3 }, solution.minimumTime(3, new int[][] {
				{ 0, 1, 2 },
				{ 1, 2, 1 },
				{ 0, 2, 4 }
		}, new int[] { 1, 3, 5 }));
		Assert.assertArrayEquals(new int[] { 0, -1 }, solution.minimumTime(2, new int[][] {
				{ 0, 1, 1 },
		}, new int[] { 1, 1 }));
		Assert.assertArrayEquals(new int[] { 0, -1, 4 }, solution.minimumTime(3, new int[][] {
				{ 0, 1, 2 },
				{ 1, 2, 1 },
				{ 0, 2, 4 }
		}, new int[] { 1, 2, 5 }));
	}
}
