package com.wen.repository.solution0200To0299.design;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        tempStack.clear();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
