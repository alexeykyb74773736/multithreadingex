package com.company.myhomework.home3;

public class App {
    public static void main(String[] args) {
        MFUQueue<PrintDocument> printQueue = new MFUQueue<>(PrintDocument.class, 10);
        printQueue.add(new PrintDocument("Document_1", 4));
        printQueue.add(new PrintDocument("Document_2", 3));
        printQueue.add(new PrintDocument("Document_3", 2));
        printQueue.add(new PrintDocument("Document_5", 4));
        printQueue.add(new PrintDocument("Document_8", 6));

        MFUQueue<ScanDocument>scanQueue = new MFUQueue<>(ScanDocument.class, 10);
        scanQueue.add(new ScanDocument("ScanDoc_1", 4));
        scanQueue.add(new ScanDocument("ScanDoc_2", 2));
        scanQueue.add(new ScanDocument("ScanDoc_3", 2));
        scanQueue.add(new ScanDocument("ScanDoc_4", 5));


        MFU mfu = new MFU(printQueue, scanQueue);



        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print(0,2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print(3,4);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(0,1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(2,3);
            }
        }).start();
    }
}
