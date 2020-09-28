package com.wen.explore.read.queueStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueAndBFSTest {

    private QueueAndBFS queueAndBFS = new QueueAndBFS();

    @Test
    public void openLock() {
        String[] deadends = {"1202","9202","0102","0302","0212","0292","0201","0203"};
        String target = "0202";
        System.out.println(queueAndBFS.openLock(deadends, target));
    }

    @Test
    public void numSquares() {
        System.out.println(queueAndBFS.numSquares(1548651));
    }
}