package com.wen.repository.solution3100To3199;

public class Solution3120To3129 {
	/**
	 * 3128. Right Triangles
	 *
	 * <p>1 <= grid.length <= 1000</p>
	 * <p>1 <= grid[i].length <= 1000</p>
	 * <p>0 <= grid[i][j] <= 1</p>
	 */
	public long numberOfRightTriangles(int[][] grid) {
		int[] row = new int[grid[0].length];
		int[] column = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					column[i]++;
					row[j]++;
				}
			}
		}
		long count = 0;
		for (int i = 0; i < column.length; i++) {
			if (column[i] <= 1) {
				continue;
			}
			for (int j = 0; j < row.length; j++) {
				if (row[j] <= 1 || grid[i][j] == 0) {
					continue;
				}
				count += (long) (column[i] - 1) * (row[j] - 1);
			}
		}

		return count;
	}
}
