package com.company.counter;

public class Counter {

    private volatile long counter = 0L;

    public void setCounter(){
        counter++;
    }

    public long getCounter(){
        return this.counter;
    }

}
