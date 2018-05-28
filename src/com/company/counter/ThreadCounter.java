package com.company.counter;

public class ThreadCounter implements Runnable {

    private Counter counter;

    public ThreadCounter(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <500 ; i++) {
            counter.setCounter();
        }
    }
}
