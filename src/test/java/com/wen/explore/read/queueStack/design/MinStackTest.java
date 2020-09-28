package com.wen.explore.read.queueStack.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void minStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}