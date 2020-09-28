package com.wen.explore.read.queueStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueStackSummaryTest {

    QueueStackSummary queueStackSummary = new QueueStackSummary();

    @Test
    public void decodeString() {
        System.out.println(queueStackSummary.decodeString("abc3[cd]xyz"));
    }

    @Test
    public void floodFill() {
        int[][] image = {
                {0,0,0},
                {0,1,1},
        };
        queueStackSummary.floodFill(image, 1, 1, 1);
    }
}