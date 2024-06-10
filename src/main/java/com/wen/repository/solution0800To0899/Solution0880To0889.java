package com.wen.repository.solution0800To0899;

import java.util.Arrays;
import java.util.HashSet;

public class Solution0880To0889 {
  /**
   * 881. Boats to Save People
   *
   * <p>1 <= people.length <= 5 * 10^4</p>
   * <p>1 <= people[i] <= limit <= 3 * 10^4</p>
   */
  public int numRescueBoats(int[] people, int limit) {
    Integer[] realPeople = Arrays.stream(people).boxed().toArray(Integer[]::new);
    Arrays.sort(realPeople, (o1, o2) -> o2 - o1);
    boolean[] checked = new boolean[realPeople.length];
    int curIndex = 0, leftCount = realPeople.length, resultCount = 0;
    while (leftCount > 0 && curIndex < realPeople.length) {
      checked[curIndex] = true;
      leftCount--;
      int lim = limit - realPeople[curIndex];
      if (lim >= realPeople[realPeople.length - 1]) {
        int maxIndex = binarySearchMax(realPeople, curIndex + 1, people.length - 1, lim);
        if (maxIndex >= 0) {
          while (maxIndex < realPeople.length && checked[maxIndex]) {
            maxIndex++;
          }
          if (maxIndex < realPeople.length) {
            checked[maxIndex] = true;
            leftCount--;
          }
        }
      }
      resultCount++;
      while (curIndex < realPeople.length && checked[curIndex]) {
        curIndex++;
      }
    }

    return resultCount;
  }

  private int binarySearchMax(Integer[] people, int fromIndex, int toIndex, int key) {
    if (fromIndex > toIndex) {
      return -1;
    }
    if (fromIndex == toIndex) {
      return fromIndex;
    }
    int middle = (fromIndex + toIndex) / 2;
    if (people[middle] > key) {
      return binarySearchMax(people, middle + 1, toIndex, key);
    } else {
      if (middle - 1 < fromIndex || people[middle - 1] > key) {
        return middle;
      } else {
        return binarySearchMax(people, fromIndex, middle - 1, key);
      }
    }
  }

  /**
   * 888. Fair Candy Swap
   * <p>
   * 1 <= A.length <= 10000
   * 1 <= B.length <= 10000
   * 1 <= A[i] <= 100000
   * 1 <= B[i] <= 100000
   */
  public int[] fairCandySwap(int[] A, int[] B) {
    int aliceSum = 0, bobSum = 0;
    HashSet<Integer> bobBars = new HashSet<>();
    for (int k : A) {
      aliceSum += k;
    }
    for (int j : B) {
      bobSum += j;
      bobBars.add(j);
    }

    int exchange = (bobSum - aliceSum) / 2;
    for (int aliceBar : A) {
      if (bobBars.contains(aliceBar + exchange)) {
        return new int[]{aliceBar, aliceBar + exchange};
      }
    }

    return null;
  }
}
