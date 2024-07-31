package com.wen.repository.solution3100To3199;

import java.util.*;

public class Solution3110To3119 {
	/**
	 * 3111. Minimum Rectangles to Cover Points
	 *
	 * <p>1 <= points.length <= 10<sup>5</sup></p>
	 * <p>points[i].length == 2</p>
	 * <p>0 <= xi == points[i][0] <= 10<sup>9</sup></p>
	 * <p>0 <= yi == points[i][1] <= 10<sup>9</sup></p>
	 * <p>0 <= w <= 10<sup>9</sup></p>
	 * <p>All pairs (xi, yi) are distinct.</p>
	 */
	public int minRectanglesToCoverPoints(int[][] points, int w) {
		Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

		int cur = -w - 1;
		int count = 0;
		for (int[] point: points) {
			if (point[0] - cur > w) {
				count++;
				cur = point[0];
			}
		}

		return count;
	}
//	public int minRectanglesToCoverPoints2(int[][] points, int w) {
//		Queue<Integer> deq =  new PriorityQueue<>((a, b) -> {return a - b;});
//		deq.addAll(Arrays.stream(points).map((a) -> a[0]).toList());
//
//		int cur = -w - 1;
//		int count = 0;
//		while (!deq.isEmpty()) {
//			Integer x = deq.poll();
//			if (x - cur > w) {
//				count++;
//				cur = x;
//			}
//		}
//		return count;
//	}

	/**
	 * 3112. Minimum Time to Visit Disappearing Nodes
	 *
	 * <p>1 <= n <= 5 * 10<sup>4</sup></p>
	 * <p>0 <= edges.length <= 10<sup>5</sup></p>
	 * <p>edges[i] == [u<sub>i</sub>, v<sub>i</sub>, length<sub>i</sub>]</p>
	 * <p>0 <= u<sub>i</sub>, v<sub>i</sub> <= n - 1</p>
	 * <p>1 <= length<sub>i</sub> <= 10<sup>5</sup></p>
	 * <p>disappear.length == n</p>
	 * <p>1 <= disappear[i] <= 10<sup>5</sup></p>
	 */
	public int[] minimumTime(int n, int[][] edges, int[] disappear) {
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Map<Integer, List<int[]>> nodeEdgesMap = new HashMap<>();
		for (int[] edge : edges) {
			nodeEdgesMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
			nodeEdgesMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
		}

		int curMinIndex = 0;
		result[curMinIndex] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[]{0, 0});
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			int minNode = arr[0], minLen = arr[1];
			if (minLen != result[minNode]) {
				continue;
			}
			List<int[]> edgeList = nodeEdgesMap.get(minNode);
			if (edgeList != null) {
				for (int[] edge : edgeList) {
					int targetIndex = edge[0];
					int len = minLen + edge[1];
					if (len < disappear[targetIndex]) {
						result[targetIndex] = result[targetIndex] == -1
							? len
							: Math.min(result[targetIndex], len);
						pq.offer(new int[]{targetIndex, len});
					}
				}
			}
		}

		return result;
	}
}
