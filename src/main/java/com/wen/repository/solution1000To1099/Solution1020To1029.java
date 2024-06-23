package com.wen.repository.solution1000To1099;

import java.util.*;

public class Solution1020To1029 {

	/**
	 * 1024. Video Stitching
	 *
	 * <p>1 <= clips.length <= 100</p>
	 * <p>0 <= start<sub>i</sub> <= end<sub>i</sub> <= 100</p>
	 * <p>1 <= time <= 100</p>
	 */
	public int videoStitching(int[][] clips, int T) {
		Arrays.sort(clips, Comparator.comparingInt(o -> o[1]));
		List<int[]> list = new ArrayList<>();

		Collections.addAll(list, clips);

		return videoStitching(list, T);
	}

	private int videoStitching(List<int[]> clips, int T) {
		if (T == 0) {
			return 0;
		}

		int min = T + 1;
		for (int i = clips.size() - 1; i >= 0 && clips.get(i)[1] >= T; i--) {
			min = Integer.min(min, clips.get(i)[0]);
			clips.remove(i);
		}

		if (min == T + 1) {
			return -1;
		} else {
			int sub = videoStitching(clips, min);
			return sub == -1 ? -1 : sub + 1;
		}
	}

	/**
	 * 1026. Maximum Difference Between Node and Ancestor
	 *
	 * <p>The number of nodes in the tree is in the range [2, 5000].</p>
	 * <p>0 <= Node.val <= 10<sup>5</sup></p>
	 */
	public int maxAncestorDiff(TreeNode root) {
		return infoOfTree(root)[2];
	}

	private int[] infoOfTree(TreeNode root) {
		int[] result = new int[]{root.val, root.val, 0};
		if (root.left != null) {
			int[] left = infoOfTree(root.left);
			result[0] = Math.min(result[0], left[0]);
			result[1] = Math.max(result[1], left[1]);
			result[2] = Math.max(left[2], Math.max(root.val - result[0], result[1] - root.val));
		}
		if (root.right != null) {
			int[] right = infoOfTree(root.right);
			result[0] = Math.min(result[0], right[0]);
			result[1] = Math.max(result[1], right[1]);
			result[2] = Math.max(Math.max(right[2], result[2]), Math.max(root.val - result[0], result[1] - root.val));
		}

		return result;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
