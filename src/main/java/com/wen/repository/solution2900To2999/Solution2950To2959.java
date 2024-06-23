package com.wen.repository.solution2900To2999;

import java.util.LinkedList;
import java.util.List;

public class Solution2950To2959 {
	/**
	 * 2951. Find the Peaks
	 *
	 * <p>3 <= mountain.length <= 100</p>
	 * <p>1 <= mountain[i] <= 100</p>
	 */
	public List<Integer> findPeaks(int[] mountain) {
		List<Integer> result = new LinkedList<>();
		int i = 0;
		while (i < mountain.length - 1) {
			while (i < mountain.length - 1 && mountain[i + 1] <= mountain[i]) {
				i++;
			}
			while (i < mountain.length - 1 && mountain[i + 1] >= mountain[i]) {
				i++;
			}
			if (i < mountain.length - 1 && mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
				result.add(i);
			}
		}
		return result;
	}
}
