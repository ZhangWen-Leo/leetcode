package com.wen.repository.solution3100To3199;

import org.junit.Assert;
import org.junit.Test;

import com.wen.util.TestDataReader;

public class Solution3120To3129Test {
	Solution3120To3129 solution = new Solution3120To3129();

	@Test
	public void numberOfRightTriangles() {
		Assert.assertEquals(2, solution.numberOfRightTriangles(TestDataReader.getInt2DArrayFromString(
			"[[0,1,0],[0,1,1],[0,1,0]]"
		)));
		Assert.assertEquals(0, solution.numberOfRightTriangles(TestDataReader.getInt2DArrayFromString(
			"[[1,0,0,0],[0,1,0,1],[1,0,0,0]]"
		)));
		Assert.assertEquals(2, solution.numberOfRightTriangles(TestDataReader.getInt2DArrayFromString(
			"[[1,0,1],[1,0,0],[1,0,0]]"
		)));
	}
}
