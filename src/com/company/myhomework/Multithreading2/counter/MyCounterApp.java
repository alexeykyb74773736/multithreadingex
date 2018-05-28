package com.company.myhomework.Multithreading2.counter;

public class MyCounterApp {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread t1 = new Thread(new MyThread(counter));
        Thread t2 = new Thread(new MyThread(counter));
        Thread t3 = new Thread(new MyThread(counter));
        Thread t4 = new Thread(new MyThread(counter));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(counter.get());

    }

}

class Counter{
    private int counter;

    public Counter(){
        this.counter = 0;
    }

    public void add(){
        synchronized (this){
            if (this.counter%1000 == 0)
                System.out.println(Thread.currentThread().getName()+" "+counter);
            this.counter++;
        }
    }

    public synchronized int get(){
        return this.counter;
    }

}

class MyThread implements Runnable{

    Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.get()<1000000) {
            counter.add();
        }
    }
}
