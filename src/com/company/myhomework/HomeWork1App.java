package com.company.myhomework;

import java.io.PrintWriter;

public class HomeWork1App {


    public static void main(String[] args) throws InterruptedException{
        PrintWriteLetter pwl = new PrintWriteLetter();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{pwl.firstLetter();}catch (InterruptedException e){e.printStackTrace();}
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{pwl.secondLetter();}catch (InterruptedException e){e.printStackTrace();}
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{pwl.thirdLetter();}catch (InterruptedException e){e.printStackTrace();}
                }
            }
        }).start();
    }

}

class PrintWriteLetter{


    boolean a,b,c;

    public PrintWriteLetter(){
        a = true;
        b = false;
        c = false;
    }

    public synchronized void firstLetter()throws InterruptedException{
        while (!a){
            wait();
        }
        System.out.println("A");
        a = false;
        b = true;
        c = false;
        notifyAll();

    }

    public synchronized void secondLetter()throws InterruptedException{
        while (!b){
            wait();
        }
        System.out.println("B");
        a = false;
        b = false;
        c = true;
        notifyAll();

    }

    public synchronized void thirdLetter()throws InterruptedException{
        while (!c){
            wait();
        }
        System.out.println("C");
        a = true;
        b = false;
        c = false;
        notifyAll();
    }

}
