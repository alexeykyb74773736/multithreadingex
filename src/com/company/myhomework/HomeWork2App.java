package com.company.myhomework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeWork2App {

    public static void main(String[] args) {

        WriterThread wt = new WriterThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    try{
                        Thread.sleep(20);
                        wt.write("Hello");
                    }
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    try{
                        Thread.sleep(20);
                        wt.write("World");
                    }
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    try{
                        Thread.sleep(20);
                        wt.write("!");
                    }
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

}

class WriterThread{

    public synchronized void write(String src){
        PrintWriter fw = null;
        try{
            fw =
                    new PrintWriter(new BufferedWriter(
                            new FileWriter("1.txt", true)));
            fw.println(src);
            fw.flush();

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            fw.close();
        }
    }

}
