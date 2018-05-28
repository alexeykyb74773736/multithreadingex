package com.company.deadlock;

public class DeadLockApp {

    public static Object l1 = new Object();
    public static Object l2 = new Object();

    public static void main(String[] args) {
        new Thread(new FirstThread()).start();
        new Thread(new SecondThead()).start();
    }

    static class FirstThread implements Runnable {
        @Override
        public void run() {
            synchronized (l1){
                System.out.println("Поток 1 захватил монитор объекта L1");
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("Поток 1 пытается захватить объект L2");
                synchronized (l2){
                    System.out.println("Поток 1 захватил объект L2");
                }
            }
        }
    }

    static class SecondThead implements Runnable {
        @Override
        public void run() {
            synchronized (l2){
                System.out.println("Поток 2 захватил монитор объекта L2");
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("Поток 2 пытается захватить объект L1");
                synchronized (l1){
                    System.out.println("Поток 2 захватил объект L2");
                }
            }
        }
    }
}