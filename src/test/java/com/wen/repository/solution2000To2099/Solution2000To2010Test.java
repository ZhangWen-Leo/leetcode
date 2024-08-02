package com.wen.repository.solution2000To2099;


import org.junit.Assert;
import org.junit.Test;

public class Solution2000To2010Test {
	Solution2000To2010 solution = new Solution2000To2010();

	@Test
	public void findOriginalArray() {
		Assert.assertArrayEquals(new int[]{1, 3, 4}, solution.findOriginalArray(new int[]{
			1,3,4,2,6,8
		}));
		Assert.assertArrayEquals(new int[]{}, solution.findOriginalArray(new int[]{
			6,3,0,1
		}));
		Assert.assertArrayEquals(new int[]{}, solution.findOriginalArray(new int[]{
			1
		}));
	}
}
