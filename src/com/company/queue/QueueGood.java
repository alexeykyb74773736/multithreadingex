package com.company.queue;

public class QueueGood {
    private int n;
    boolean flag = false;
    public synchronized int get(){
        while (!flag){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("Получено "+n);
        flag = false;
        notify();
        return n;
    }

    public synchronized void put(int n){
        while (flag){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        this.n = n;
        flag = true;
        System.out.println("Отправлено "+n);
        notify();
    }
}
