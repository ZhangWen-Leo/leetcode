package com.wen.explore.read.queueStack.design;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        tempQueue.clear();
        while (!queue.isEmpty()) {
            tempQueue.offer(queue.poll());
        }
        queue.offer(x);
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
