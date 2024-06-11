package com.wen.repository.solution0400To0499;

import java.util.Arrays;
import java.util.HashSet;

public class Solution0410To0419 {

	/**
	 * 416. Partition Equal Subset Sum
	 */
	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int num :
			nums) {
			sum += num;
		}
		if (sum % 2 == 1) {
			return false;
		}
		int target = sum / 2;

		// 排序数组
		Arrays.sort(nums);
		HashSet<Integer> set = new HashSet<>();
		set.add(target);

		for (int i = nums.length - 1; i >= 0; i--) {
			HashSet<Integer> cloneSet = (HashSet<Integer>) set.clone();
			for (Integer currentTarget :
				cloneSet) {
				if (nums[i] < currentTarget) {
					set.add(currentTarget - nums[i]);
				} else if (nums[i] == currentTarget) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 419. Battleships in a Board
	 *
	 * <p>m == board.length</p>
	 * <p>n == board[i].length</p>
	 * <p>1 <= m, n <= 200</p>
	 * <p>board[i][j] is either '.' or 'X'.</p>
	 */
	public int countBattleships(char[][] board) {
		int result = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X') {
					result++;

					board[i][j] = '.';
					for (int k = i + 1; k < board.length && board[k][j] == 'X'; k++) {
						board[k][j] = '.';
					}
					for (int k = j + 1; k < board[i].length && board[i][k] == 'X'; k++) {
						board[i][k] = '.';
					}
				}
			}
		}
		return result;
	}
}
