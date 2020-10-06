package com.wen.repository.offer.design;

import java.util.Stack;

/**
 * 09. 用两个栈实现队列
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    boolean nowOne;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.clear();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }
        else {
            return stack1.pop();
        }
    }
}
