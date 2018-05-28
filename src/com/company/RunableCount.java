package com.company;

public class RunableCount implements Runnable{
    @Override
    public void run() {
        long num = 0;
        while (num<999999999){
            num++;
        }
        System.out.println("Работа счетчика завершена "+num);
    }
}
