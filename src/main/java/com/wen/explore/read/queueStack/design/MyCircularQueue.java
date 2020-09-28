package com.wen.explore.read.queueStack.design;

public class MyCircularQueue {

    private int[] nums;
    private int front;
    private int rear;
    private int size;
    private int length;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        nums = new int[k+1];
        front = 0;
        rear = 0;
        size = k;
        length = k+1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        else {
            nums[rear] = value;
            rear = nextIndex(rear);
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        else {
            front = nextIndex(front);
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[previousIndex(rear)];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return nextIndex(rear) == front;
    }

    private int previousIndex(int i) {
        return (i + length - 1) % length;
    }

    private int nextIndex(int i) {
        return (i + 1) % length;
    }
}
