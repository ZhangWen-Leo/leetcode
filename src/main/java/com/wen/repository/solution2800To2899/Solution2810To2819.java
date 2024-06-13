package com.wen.repository.solution2800To2899;


import java.util.*;

public class Solution2810To2819 {
	/**
	 * 2813. Maximum Elegance of a K-Length Subsequence
	 *
	 * <p>1 <= items.length == n <= 10<sup>5</sup></p>
	 * <p>items[i].length == 2</p>
	 * <p>items[i][0] == profit<sub>i</sub></p>
	 * <p>items[i][1] == category<sub>i</sub></p>
	 * <p>1 <= profit<sub>i</sub> <= 10<sup>9</sup></p>
	 * <p>1 <= category<sub>i</sub> <= n</p>
	 * <p>1 <= k <= n</p>
	 */
	public long findMaximumElegance(int[][] items, int k) {
		Arrays.sort(items, (a, b) -> b[0] - a[0]);
		Set<Integer> used = new HashSet<>(k);
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		long total = 0;
		boolean multi = false;
		total += items[i][0];
		map.put(items[i][1], 1);
		used.add(i);
		while (used.size() < k) {
			if (multi) {
				while (i < items.length && used.contains(i)) {
					i++;
				}
				if (i < items.length) {
					total += items[i][0];
					map.put(items[i][1], map.getOrDefault(items[i][1], 0) + 1);
					used.add(i);
				} else {
					return 0;
				}
			} else {
				while (i < items.length && map.get(items[i][1]) != null) {
					i++;
				}
				if (i < items.length) {
					total += items[i][0];
					map.put(items[i][1], map.getOrDefault(items[i][1], 0) + 1);
					used.add(i);
				} else {
					multi = true;
					i = 0;
				}
			}
		}

		int lastUsed = items.length - 1;
		int firstNonUsed = 0;
		while (!used.contains(lastUsed)) {
			lastUsed--;
		}
		while (used.contains(firstNonUsed)) {
			firstNonUsed++;
		}
		long curResult = total + (long) map.size() * map.size();
		while (firstNonUsed < lastUsed && map.get(items[lastUsed][1]) == 1) {
			total -= items[lastUsed][0];
			if (map.get(items[lastUsed][1]) == 1) {
				map.remove(items[lastUsed][1]);
			} else {
				map.put(items[lastUsed][1], map.get(items[lastUsed][1]) - 1);
			}
			used.remove(lastUsed);

			total += items[firstNonUsed][0];
			map.put(items[firstNonUsed][1], map.getOrDefault(items[firstNonUsed][1], 0) + 1);
			used.add(firstNonUsed);

			long newResult = total + (long) map.size() * map.size();
			if (newResult >= curResult) {
				curResult = newResult;
				while (!used.contains(lastUsed)) {
					lastUsed--;
				}
				while (used.contains(firstNonUsed)) {
					firstNonUsed++;
				}
			} else {
				break;
			}
		}

		return curResult;
	}
}
