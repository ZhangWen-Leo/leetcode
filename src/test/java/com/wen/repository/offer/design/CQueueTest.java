package com.wen.repository.offer.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class CQueueTest {

    private CQueue cQueue = new CQueue();

    @Test
    public void test1() {
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(12);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(10);
        cQueue.appendTail(9);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(20);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(8);
        cQueue.appendTail(20);
        cQueue.appendTail(1);
        cQueue.appendTail(11);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

}