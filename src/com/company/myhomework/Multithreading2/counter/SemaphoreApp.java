package com.company.myhomework.Multithreading2.counter;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    private static final boolean[] PARKING_PLACE = new boolean[5];

    private static final Semaphore SEMAPHORE =
            new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    public static class Car implements Runnable{

        private int carNumber;

        public Car(int num){
            this.carNumber = num;
        }

        @Override
        public void run(){
            System.out.println("Автомобиль №"+this.carNumber+" подъехал к парковке");
            try{
                SEMAPHORE.acquire();
                int parkingNumber = -1;
                synchronized (PARKING_PLACE){
                    for (int i = 0; i <PARKING_PLACE.length ; i++) {
                        if(!PARKING_PLACE[i]){
                            PARKING_PLACE[i] = true;
                            parkingNumber = i;
                            System.out.println("Автомобиль №"+this.carNumber+" припарковался на месте "+parkingNumber);
                            break;
                        }
                    }
                }
                Thread.sleep(5000);
                synchronized (PARKING_PLACE){
                    PARKING_PLACE[parkingNumber] = false;
                }
                SEMAPHORE.release();
                System.out.println("Автомобиль №"+this.carNumber+" уехал с парковки");
            }catch (InterruptedException e){e.printStackTrace();}
        }
    }

}
