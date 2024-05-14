package com.wen.repository.solution2200To2299.design;

import java.util.HashMap;

/**
 * 2671. Frequency Tracker
 * <p>
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
public class FrequencyTracker {
  private HashMap<Integer, Integer> countMap = new HashMap<>();
  private HashMap<Integer, Integer> frequencyMap = new HashMap<>();

  public FrequencyTracker() {
  }

  public void add(int number) {
    this.countMap.putIfAbsent(number, 0);
    int beforeCount = this.countMap.get(number);
    int curCount = beforeCount + 1;
    this.countMap.put(number, curCount);
    if (beforeCount > 0) {
      this.frequencyMap.put(beforeCount, this.frequencyMap.get(beforeCount) - 1);
    }
    this.frequencyMap.putIfAbsent(curCount, 0);
    this.frequencyMap.put(curCount, this.frequencyMap.get(curCount) + 1);
  }

  public void deleteOne(int number) {
    if (this.countMap.get(number) == null || this.countMap.get(number) == 0) {
      return;
    }
    int beforeCount = this.countMap.get(number);
    int curCount = beforeCount - 1;
    this.countMap.put(number, curCount);
    this.frequencyMap.put(beforeCount, this.frequencyMap.get(beforeCount) - 1);
    if (curCount > 0) {
      this.frequencyMap.putIfAbsent(curCount, 0);
      this.frequencyMap.put(curCount, this.frequencyMap.get(curCount) + 1);
    }
  }

  public boolean hasFrequency(int frequency) {
    if (this.frequencyMap.get(frequency) == null) {
      return false;
    }
    return this.frequencyMap.get(frequency) > 0;
  }
}
