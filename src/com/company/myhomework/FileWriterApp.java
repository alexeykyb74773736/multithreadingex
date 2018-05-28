package com.company.myhomework;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileWriterApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ThreadWhileCount twc = new ThreadWhileCount(counter);
        Thread t1 = new Thread(twc);
        Thread t2 = new Thread(twc);
        Thread t3 = new Thread(twc);
        Thread t4 = new Thread(twc);
        Thread t5 = new Thread(twc);
        Thread t6 = new Thread(twc);
        Thread t7 = new Thread(twc);
        Thread t8 = new Thread(twc);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();

        System.out.println(counter.getCounter());

    }
}

class Counter {

    private int counter;

    public Counter(){
        counter = 0;
    }

    public  void add(){

            if (this.counter % 100 == 0)
                System.out.println(Thread.currentThread().getName()+" "+counter);
            this.counter++;

    }

    public synchronized long getCounter(){
        return this.counter;
    }

}
class ThreadWhileCount implements Runnable{

    Counter counter;

    public ThreadWhileCount(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=0;i<1000000;i++) {
            counter.add();
        }
    }
}

