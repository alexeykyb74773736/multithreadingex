package com.company.myhomework.Multithreading2.counter;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounterApp {

    public static void main(String[] args) throws InterruptedException{
        LockCounter counter = new LockCounter();
        Thread t1 = new Thread(new Thread1(counter));
        Thread t2 = new Thread(new Thread2(counter));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.counter);

    }

}

class LockCounter{

    static  int counter = 0;
    static ReentrantLock counterLock = new ReentrantLock(true);


    public  static void increment(){
        counter++;
    }
}

class Thread1 implements Runnable{
    private LockCounter counter;

    public Thread1(LockCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000000 ; i++) {
            counter.increment();
        }
    }
}

class Thread2 implements Runnable{
    private LockCounter counter;

    public Thread2(LockCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000000 ; i++) {
            counter.increment();
        }
    }
}
