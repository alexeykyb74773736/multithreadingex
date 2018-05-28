package com.company.myhomework.Multithreading2.counter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FerryApp {
    private static final CyclicBarrier CYCLIC_BARRIER =
            new CyclicBarrier(3, new FerryBoat());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <9 ; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(1000);
        }
    }

    public static class FerryBoat implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Паром переправил автомобили");
        }
    }

    public static class Car implements Runnable{

        private int carNumber;

        public Car(int number){
            this.carNumber = number;
        }

        @Override
        public void run() {
            System.out.println("Автомобиль #"+this.carNumber+ " подъехал к поромной переправе");

            try {
                CYCLIC_BARRIER.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
