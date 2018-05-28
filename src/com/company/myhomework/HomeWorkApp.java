package com.company.myhomework;

public class HomeWorkApp {
    public static void main(String[] args) {
        Letters let = new Letters();
        PrintLetter pl = new PrintLetter(let);
        new Thread(new Runnable() {
            @Override
            public void run() {
                pl.print();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pl.print();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                pl.print();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                pl.print();
            }
        }).start();

    }
}

class PrintLetter{
    Letters let;

    public PrintLetter(Letters let){
        this.let = let;
    }

    public void print(){
        for (int i = 0; i < 5; i++) {
            let.printLetter();
        }

    }

}

class Letters{

    private char[] arr;
    private int index;

    public Letters(){
        arr = new char[4];
        arr[0] = 'A';
        arr[1] = 'B';
        arr[2] = 'C';
        arr[3] = 'D';
        index = 0;

    }

    public synchronized void printLetter(){
        System.out.println("Поток № "+Thread.currentThread().getName()+" выводит "+arr[index]);
        if (index == arr.length-1) index = 0;
        else index++;
    }

}
