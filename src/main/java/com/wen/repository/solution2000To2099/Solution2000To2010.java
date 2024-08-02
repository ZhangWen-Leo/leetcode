package com.wen.repository.solution2000To2099;

import java.util.*;

public class Solution2000To2010 {
	/**
	 * 2007. Find Original Array From Doubled Array
	 *
	 * <p>1 <= changed.length <= 10<sup>5</sup></p>
	 * <p>0 <= changed[i] <= 10<sup>5</sup></p>
	 */
	public int[] findOriginalArray(int[] changed) {
		if (changed.length % 2 == 1) {
			return new int[0];
		}
		Arrays.sort(changed);
		List<Integer> list = new LinkedList<>();
		int[] result = new int[changed.length / 2];
		int i = 0;
		for (int num: changed) {
			if (list.isEmpty() || num < list.getFirst()) {
				if (i >= changed.length / 2) {
					return new int[0];
				}
				result[i++] = num;
				list.add(num * 2);
			} else if (num == list.getFirst()) {
				list.removeFirst();
			} else {
				return new int[0];
			}
		}
		if (list.isEmpty()) {
			return result;
		} else {
			return new int[0];
		}
	}
}
