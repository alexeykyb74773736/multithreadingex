package com.company.syncounter;

public class SyncCounter implements Runnable{
    private CounterObjSync counter;

    public SyncCounter(CounterObjSync counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            counter.increaseCounter();
        }
    }
}


