package com.demo.multithreading;

class T1 extends Thread{
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi");
            // To give time to do parallel execution in sequence
            try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}

        }
    }
}

class T2 extends Thread {
    //we need to use run method
    public void run() {
        for( int i = 1; i <= 10; i++) {
            System.out.println("hello");
            try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}

class T3 implements Runnable{
    // Using runnable to create threads instead
    public void run(){
        for(int i = 1; i<=10; i++) {
            System.out.println("hola");
            try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}

public class ThreadsDemo {

    public static void main (String a[]) throws InterruptedException {

        T1 obj1 = new T1();
        T2 obj2 = new T2();
        Runnable obj3 = new T3();

        Thread t = new Thread(obj3);
        
        obj1.start();
        Thread.sleep(7);
        obj2.start();
        Thread.sleep(7);
        t.start();
    }
}
