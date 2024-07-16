package com.wen.repository.solution2900To2999;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	/**
	 * 2956. Find Common Elements Between Two Arrays
	 *
	 * <p>n == nums1.length</p>
	 * <p>m == nums2.length</p>
	 * <p>1 <= n, m <= 100</p>
	 * <p>1 <= nums1[i], nums2[i] <= 100</p>
	 */
	public int[] findIntersectionValues(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[]{0, 0};

		for (int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int num : nums2) {
			if (map.containsKey(num)) {
				result[1]++;
				result[0] += map.get(num);
				map.put(num, 0);
			}
		}

		return result;
	}
}
