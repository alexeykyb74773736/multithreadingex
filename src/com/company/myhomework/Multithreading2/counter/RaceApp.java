package com.company.myhomework.Multithreading2.counter;

import java.util.concurrent.CountDownLatch;

public class RaceApp {

    private static final CountDownLatch START = new CountDownLatch(8);

    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <5 ; i++) {
            new Thread(
                    new Car(i, (int) Math.random()*100+50)).start();
            Thread.sleep(1000);
        }
        while (START.getCount() > 3)
            Thread.sleep(100);
        Thread.sleep(1000);
        System.out.println("На старт!");
        START.countDown();
        System.out.println("Внимание!");
        Thread.sleep(1000);
        START.countDown();
        System.out.println("Марш!");
        Thread.sleep(1000);
        START.countDown();
    }

    public static class Car implements Runnable{
        private int carNumber;
        private int carSpeed;

        public Car(int number, int speed){
            this.carNumber = number;
            this.carSpeed = speed;
        }

        @Override
        public void run() {
            System.out.println("Автомобиль №"+this.carNumber+" подъехал к стартовой линии");
            START.countDown();
            try {
                START.await();
                Thread.sleep(trackLength/this.carSpeed);
                System.out.println("Автомобиль №"+this.carNumber+" финишировал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
