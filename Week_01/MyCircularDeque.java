/*
 * File Name:MyCircularDeque is created on 2020/8/16 1:50 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description:
 * @date: 2020/8/16 1:50 下午
 * @since JDK 1.8
 */
public class MyCircularDeque {

    private final int capacity;
    private final int[] queue;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        queue = new int[capacity];
        front = 0;
        rear = 0;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        boolean result1 = circularDeque.insertLast(1);// 返回 true
        assert result1;
        boolean result2 = circularDeque.insertLast(2);// 返回 true
        assert result2;
        boolean result3 = circularDeque.insertFront(3);// 返回 true
        assert result3;
        boolean result4 = circularDeque.insertFront(4);// 已经满了，返回 false
        assert !result4;
        int rear = circularDeque.getRear();// 返回 2
        assert rear == 2;
        boolean full = circularDeque.isFull();// 返回 true
        assert full;
        boolean result5 = circularDeque.deleteLast();// 返回 true
        assert result5;
        boolean result6 = circularDeque.insertFront(4);// 返回 true
        assert result6;
        int front = circularDeque.getFront();// 返回 4
        assert front == 4;
        System.out.println("Passed!");
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front + 1) % capacity;
        queue[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        queue[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
