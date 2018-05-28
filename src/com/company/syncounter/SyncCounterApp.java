package com.company.syncounter;

public class SyncCounterApp {


    public static void main(String[] args) {


        CounterObjSync counter = new CounterObjSync();
        Runnable r1 = new SyncCounter(counter);
        Runnable r2 = new SyncCounter(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
            System.out.println(counter.getCounter());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
