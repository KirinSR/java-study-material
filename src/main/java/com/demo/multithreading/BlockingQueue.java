package com.demo.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public boolean add(int item) throws InterruptedException {
        synchronized (q) {
            while (q.size() == capacity){
                q.wait();
            }
            q.add(item);
            q.notifyAll();
            return true;
        }
    }

    public int remove() throws InterruptedException {
        synchronized (q) {
            while (q.isEmpty()){
                q.wait();

            }
            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }
}
