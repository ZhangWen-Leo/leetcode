package com.wen.repository.solution2200To2299.design;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrequencyTrackerTest {


  @Test
  public void test1() {
    FrequencyTracker tracker = new FrequencyTracker();
    tracker.add(4);
    tracker.deleteOne(3);
    Assert.assertTrue(tracker.hasFrequency(1));
    tracker.deleteOne(6);
    tracker.add(8);
    tracker.add(6);
    tracker.deleteOne(6);
    tracker.deleteOne(4);
    Assert.assertTrue(tracker.hasFrequency(1));
    tracker.deleteOne(4);
    Assert.assertTrue(tracker.hasFrequency(1));
    tracker.add(3);
    tracker.add(8);
  }
}