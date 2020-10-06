package com.wen.repository.solution0100To0199.design;

/**
 * 155. Min Stack
 */
public class MinStack {

    private int[][] stack;
    private int topIndex;
    private int capacity = 50;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[capacity+1][2];
        topIndex = 0;
    }

    public void push(int x) {
        if (isFull()) {
            int newCapacity = capacity + (capacity >> 1);
            int[][] newStack = new int[newCapacity][2];
            System.arraycopy(stack, 0, newStack, 0, capacity);
            stack = newStack;
            capacity = newCapacity;
        }
        stack[topIndex][0] = x;
        stack[topIndex][1] = Integer.min(topIndex == 0 ? Integer.MAX_VALUE : stack[topIndex-1][1], x);
        topIndex++;
    }

    public void pop() {
        if (!isEmpty()) {
            topIndex--;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stack[topIndex-1][0];
        }

        return -1;
    }

    public int getMin() {
        if (!isEmpty()) {
            return stack[topIndex-1][1];
        }

        return -1;
    }

    private boolean isFull() {
        return topIndex >= capacity - 1;
    }

    private boolean isEmpty() {
        return topIndex <= 0;
    }
}
