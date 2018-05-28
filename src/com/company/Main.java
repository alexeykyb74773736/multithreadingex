package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Запуск счетчика");

        new Thread(new Runnable() {
            @Override
            public void run() {
                long num = 0;
                while (num<999999999){
                    num++;
                }
                System.out.println("Работа счетчика завершена "+num);
            }
        }).start();

        System.out.println("Пока выполняется счетчик посчитаем квадрат ПИ");
        System.out.println(Math.PI * Math.PI);
    }
}

class OneThread{
    public OneThread(){
        System.out.println("Запуск счетчика");
        counter();
        System.out.println("Пока выполняется счетчик посчитаем квадрат ПИ");
        System.out.println(Math.PI * Math.PI);
    }

    private void counter(){
        long num = 0;
        while (num<999999999){
            num++;
        }
        System.out.println("Работа счетчика завершена "+num);
    }
}
