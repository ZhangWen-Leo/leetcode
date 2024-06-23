package com.wen.repository.solution1000To1099;

import org.junit.Assert;
import org.junit.Test;

public class Solution1020To1029Test {
	Solution1020To1029 solution = new Solution1020To1029();


	@Test
	public void videoStitching() {
		Assert.assertEquals(3, solution.videoStitching(new int[][]{
			{0, 2},
			{4, 6},
			{8, 10},
			{1, 9},
			{1, 5},
			{5, 9}
		}, 10));
		Assert.assertEquals(-1, solution.videoStitching(new int[][]{
			{0, 1},
			{1, 2},
		}, 5));
		Assert.assertEquals(3, solution.videoStitching(new int[][]{
			{0, 1},
			{6, 8},
			{0, 2},
			{5, 6},
			{0, 4},
			{0, 3},
			{6, 7},
			{1, 3},
			{4, 7},
			{1, 4},
			{2, 5},
			{2, 6},
			{3, 4},
			{4, 5},
			{5, 7},
			{6, 9}
		}, 9));
	}

	@Test
	public void maxAncestorDiff() {
		Assert.assertEquals(7, solution.maxAncestorDiff(new Solution1020To1029.TreeNode(8,
			new Solution1020To1029.TreeNode(3,
				new Solution1020To1029.TreeNode(1),
				new Solution1020To1029.TreeNode(6,
					new Solution1020To1029.TreeNode(4),
					new Solution1020To1029.TreeNode(7)
				)
			),
			new Solution1020To1029.TreeNode(10,
				null,
				new Solution1020To1029.TreeNode(14, new Solution1020To1029.TreeNode(13), null)
			)
		)));
		Assert.assertEquals(3, solution.maxAncestorDiff(new Solution1020To1029.TreeNode(1,
			null,
			new Solution1020To1029.TreeNode(2,
				null,
				new Solution1020To1029.TreeNode(0, new Solution1020To1029.TreeNode(3), null)
			)
		)));
		Assert.assertEquals(4, solution.maxAncestorDiff(new Solution1020To1029.TreeNode(2,
			null,
			new Solution1020To1029.TreeNode(0,
				null,
				new Solution1020To1029.TreeNode(4,
					null,
					new Solution1020To1029.TreeNode(3,
						null,
						new Solution1020To1029.TreeNode(1)
					)
				)
			)
		)));
		Assert.assertEquals(10, solution.maxAncestorDiff(new Solution1020To1029.TreeNode(2,
			new Solution1020To1029.TreeNode(0,
				new Solution1020To1029.TreeNode(3,
					new Solution1020To1029.TreeNode(4,
						new Solution1020To1029.TreeNode(5),
						null
					),
					null
				),
				new Solution1020To1029.TreeNode(10)
			),
			new Solution1020To1029.TreeNode(8,
				new Solution1020To1029.TreeNode(7),
				new Solution1020To1029.TreeNode(1,
					null,
					new Solution1020To1029.TreeNode(6,
						new Solution1020To1029.TreeNode(1),
						null
					)
				)
			)
		)));
	}
}
