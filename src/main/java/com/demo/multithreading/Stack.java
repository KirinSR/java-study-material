package com.demo.multithreading;

public class Stack {

    private int stackTop;
    private int[] array;

    public Stack(int capacity){
        array = new int[capacity];
        stackTop = -1;
    }

    public synchronized boolean push(int element) {
        if (isFull()) return false;
        ++ stackTop;

        try {Thread.sleep(1000);} catch (Exception ignored) {}

        array[stackTop] = element;
        return true;
    }

    public synchronized int pop () {
        if (isEmpty()) return Integer.MIN_VALUE;
        int element = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;

        try {Thread.sleep(1000);} catch (Exception ignored) {}

        stackTop --;
        return element;
    }

    public boolean isEmpty(){
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }
}
