package com.company.counter;

public class CounterApp {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable r1 = new ThreadCounter(counter);
        Runnable r2 = new ThreadCounter(counter);
        Runnable r3 = new ThreadCounter(counter);
        Runnable r4 = new ThreadCounter(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            Thread.sleep(1000);
            System.out.println(counter.getCounter());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
