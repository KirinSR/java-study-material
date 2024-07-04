package com.demo.multithreading;

public class Deadlock {

    String lock1 = "naruto";
    String lock2 = "sasuke";

    Thread t1 = new Thread( () -> {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.println(lock2 + " acquired");
            }
        }
    }, "t1");

    Thread t2 = new Thread(() -> {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1) {
                System.out.println(lock1 + " acquired");
            }
        }
    }, "t2");

}
