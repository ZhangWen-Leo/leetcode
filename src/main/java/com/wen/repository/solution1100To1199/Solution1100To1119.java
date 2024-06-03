package com.wen.repository.solution1100To1199;

public class Solution1100To1119 {
  /**
   * 1103. Distribute Candies to People
   */
  public int[] distributeCandies(int candies, int num_people) {
    int term = 1;
    int nextTerm = (1 + num_people) * num_people / 2;
    while (candies > nextTerm) {
      candies -= nextTerm;
      term++;
      nextTerm = ((1 + num_people) + 2 * num_people * (term - 1)) * num_people / 2;
    }
    int[] result = new int[num_people];
    for (int i = 0; i < num_people; i++) {
      result[i] = (term - 2) * (term - 1) / 2 * num_people + (term - 1) * (i + 1);
      if (candies > 0) {
        int next = (term - 1) * num_people + i + 1;
        if (candies > next) {
          candies -= next;
          result[i] += next;
        } else {
          result[i] += candies;
          candies = 0;
        }
      }
    }
    return result;
  }
}
