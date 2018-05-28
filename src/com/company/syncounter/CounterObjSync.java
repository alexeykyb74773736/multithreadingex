package com.company.syncounter;

public class CounterObjSync {

    private int counter = 0;

    public void increaseCounter(){

        synchronized (this){
            counter++;
        }
    }

    public int getCounter(){
        return counter;
    }

}
