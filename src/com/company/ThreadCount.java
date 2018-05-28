package com.company;

public class ThreadCount extends Thread {
    @Override
    public void run() {
        long num = 0;
        while (num<999999999){
            num++;
        }
        System.out.println("Работа счетчика завершена "+num);
    }
}
