package com.wen.repository.solution1900To1999;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution1970To1979 {
	/**
	 * 1976. Number of Ways to Arrive at Destination
	 *
	 * <p>1 <= n <= 200</p>
	 * <p>n - 1 <= roads.length <= n * (n - 1) / 2</p>
	 * <p>roads[i].length == 3</p>
	 * <p>0 <= u<sub>i</sub>, v<sub>i</sub> <= n - 1</p>
	 * <p>1 <= time<sub>i</sub> <= 10<sup>9</sup></p>
	 * <p>u<sub>i</sub> != v<sub>i</sub></p>
	 * <p>There is at most one road connecting any two intersections.</p>
	 * <p>You can reach any intersection from any other intersection.</p>
	 */
	public int countPaths(int n, int[][] roads) {
		int[][] result = new int[n][2];
		for (int i = 0; i < n; i++) {
			result[i][0] = -1;
			result[i][1] = 0;
		}
		Set<Integer> set = new HashSet<>();
		set.add(n - 1);
		result[n - 1][0] = 0;
		result[n - 1][1] = 1;
		Set<int[]> consideredRoad = new HashSet<>();
		Set<int[]> leftRoad = new HashSet<>();
		Collections.addAll(leftRoad, roads);
		int uncertainNodeCount = n - 1;
		while (uncertainNodeCount > 0) {
			Set<int[]> needDeleteRoad = new HashSet<>();
			for (int[] road : leftRoad) {
				if (set.contains(road[0]) && set.contains(road[1])) {
					needDeleteRoad.add(road);
				} else if (set.contains(road[0]) || set.contains(road[1])) {
					consideredRoad.add(road);
					needDeleteRoad.add(road);
				}
			}
			setDelete(leftRoad, needDeleteRoad);
			Set<Integer> minNodes = new HashSet<>();
			int minLength = Integer.MAX_VALUE;
			for (int[] road : consideredRoad) {
				int contained, notContained;
				if (set.contains(road[0]) && !set.contains(road[1])) {
					contained = road[0];
					notContained = road[1];
				} else if (!set.contains(road[0]) && set.contains(road[1])) {
					contained = road[1];
					notContained = road[0];
				} else {
//					something wrong
					return -1;
				}
				int len = result[contained][0] + road[2];
				if (len < minLength) {
					minNodes.clear();
					minNodes.add(notContained);
					minLength = len;
				} else if (len == minLength) {
					minNodes.add(notContained);
				}
			}
			for (int minNode : minNodes) {
				result[minNode][0] = minLength;
			}
			set.addAll(minNodes);
			uncertainNodeCount -= minNodes.size();
			needDeleteRoad = new HashSet<>();
			for (int[] road : consideredRoad) {
				if (set.contains(road[0]) && set.contains(road[1])) {
					if (minNodes.contains(road[0]) && result[road[0]][0] == result[road[1]][0] + road[2]) {
						result[road[0]][1] = (result[road[0]][1] + result[road[1]][1]) % 1000000007;
					} else if (minNodes.contains(road[1]) && result[road[1]][0] == result[road[0]][0] + road[2]) {
						result[road[1]][1] = (result[road[1]][1] + result[road[0]][1]) % 1000000007;
					}
					needDeleteRoad.add(road);
				}
			}
			setDelete(consideredRoad, needDeleteRoad);
		}
		return result[0][1];
	}

	private <T> void setDelete(Set<T> set, Set<T> needDelete) {
		for (T item : needDelete) {
			set.remove(item);
		}
	}
}
