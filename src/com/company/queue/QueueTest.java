package com.company.queue;

public class QueueTest {
    private int n;

    public synchronized int get(){
        System.out.println("Получено "+n);
        return n;
    }

    public synchronized void put(int n){
        this.n = n;
        System.out.println("Отправлено "+n);
    }
}
