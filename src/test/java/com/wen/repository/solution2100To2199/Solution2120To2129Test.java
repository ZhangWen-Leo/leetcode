package com.wen.repository.solution2100To2199;

import org.junit.Assert;
import org.junit.Test;

public class Solution2120To2129Test {
	Solution2120To2129 solution = new Solution2120To2129();

	@Test
	public void capitalizeTitle() {
		Assert.assertEquals("Capitalize The Title", solution.capitalizeTitle("capiTalIze tHe titLe"));
		Assert.assertEquals("First Letter of Each Word", solution.capitalizeTitle("First leTTeR of EACH Word"));
		Assert.assertEquals("i Love Leetcode", solution.capitalizeTitle("i lOve leetcode"));
	}

}
