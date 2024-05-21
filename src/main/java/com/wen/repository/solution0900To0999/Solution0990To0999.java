package com.wen.repository.solution0900To0999;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution0990To0999 {

  /**
   * 992. Subarrays with K Different Integers
   *
   * <p>1 <= nums.length <= 2 * 104</p>
   * <p>1 <= nums[i], k <= nums.length</p>
   * <p>
   *   TODO: 下方的解法正确但超时了
   * </p>
   */
  public int subarraysWithKDistinct(int[] A, int K) {
    int left = 0, right = 0;
    Map<Integer, Integer> countMap = new HashMap<>();
    int count = 0;

    while (countMap.size() >= K || right < A.length) {
      if (countMap.size() < K) {
        countMap.putIfAbsent(A[right], 0);
        countMap.put(A[right], countMap.get(A[right]) + 1);
        right++;
      } else if (countMap.size() == K) {
        int curLeft = left;
        while (countMap.size() == K) {
          count++;
          if (countMap.get(A[curLeft]) == 1) {
            countMap.remove(A[curLeft]);
          } else {
            countMap.put(A[curLeft], countMap.get(A[curLeft]) - 1);
          }
          curLeft++;
        }
        do {
          curLeft--;
          countMap.putIfAbsent(A[curLeft], 0);
          countMap.put(A[curLeft], countMap.get(A[curLeft]) + 1);
        } while (curLeft > left);

        if (right < A.length) {
          countMap.putIfAbsent(A[right], 0);
          countMap.put(A[right], countMap.get(A[right]) + 1);
          right++;
        } else {
          break;
        }
      } else {
        if (countMap.get(A[left]) == 1) {
          countMap.remove(A[left]);
        } else {
          countMap.put(A[left], countMap.get(A[left]) - 1);
        }
        left++;
      }
    }

    return count;
  }

  /**
   * 994. Rotting Oranges
   *
   * <p>m == grid.length</p>
   * <p>n == grid[i].length</p>
   * <p>1 <= m, n <= 10</p>
   * <p>grid[i][j] is 0, 1, or 2.</p>
   */
  public int orangesRotting(int[][] grid) {
    LinkedList<int[]> rottenOranges = new LinkedList<>();
    int freshOrangeCount = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          freshOrangeCount++;
        } else if (grid[i][j] == 2) {
          rottenOranges.add(new int[]{i, j});
        }
      }
    }

    int steps = 0;
    while (freshOrangeCount != 0 && !rottenOranges.isEmpty()) {
      int[] last = rottenOranges.getLast();
      int[] first;
      do {
        first = rottenOranges.getFirst();
        int i = first[0], j = first[1];
        if (i > 0 && grid[i - 1][j] == 1) {
          grid[i - 1][j] = 2;
          rottenOranges.add(new int[]{i - 1, j});
          freshOrangeCount--;
        }
        if (j > 0 && grid[i][j - 1] == 1) {
          grid[i][j - 1] = 2;
          rottenOranges.add(new int[]{i, j - 1});
          freshOrangeCount--;
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
          grid[i + 1][j] = 2;
          rottenOranges.add(new int[]{i + 1, j});
          freshOrangeCount--;
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
          grid[i][j + 1] = 2;
          rottenOranges.add(new int[]{i, j + 1});
          freshOrangeCount--;
        }
        rottenOranges.removeFirst();
      } while (!rottenOranges.isEmpty() && first != last);
      steps++;
    }

    return freshOrangeCount > 0 ? -1 : steps;
  }
}
