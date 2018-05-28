package com.company.myhomework.home3;

public class MFU {

    private MFUQueue<PrintDocument> printQueue;
    private MFUQueue<ScanDocument> scanQueue;

    boolean isPrinted;
    boolean isScanned;

    public MFU(MFUQueue<PrintDocument> pd, MFUQueue<ScanDocument> sd){
        this.printQueue = pd;
        this.scanQueue = sd;
        isPrinted = false;
        isScanned = false;
    }

    public void print(int start, int end){
        for (int i = start; i<=end ; i++){
            PrintDocument pd = printQueue.get(i);
            System.out.println("Поток № "+Thread.currentThread().getName()+" Начинаем печать документа "+pd.getName());
            for (int j = 1; j <pd.getPages() ; j++) {
                System.out.println("Печатаю страницу № "+j+" документа "+pd.getName());
            }
            System.out.println("Документ "+pd.getName()+" распечатан");
        }
    }

//    public synchronized void print(int start, int end){
//        try{
//         while (isPrinted){
//             wait();
//         }
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//        isPrinted = true;
//        for (int i = start; i<=end ; i++){
//            PrintDocument pd = printQueue.get(i);
//            System.out.println("Поток № "+Thread.currentThread().getName()+" Начинаем печать документа "+pd.getName());
//            for (int j = 1; j <pd.getPages() ; j++) {
//                System.out.println("Печатаю страницу № "+j+" документа "+pd.getName());
//            }
//            System.out.println("Документ "+pd.getName()+" распечатан");
//        }
//        notify();
//        isPrinted = false;
//
//    }
    public synchronized void scan(int start, int end){
        try{
            while (isScanned){
                wait();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        isScanned = true;
        for (int i = start; i <= end; i++){
            ScanDocument sd =scanQueue.get(i);
            System.out.println("Начинаем сканирование документа "+sd.getName());
            for (int j = 1; j <sd.getPages() ; j++) {
                System.out.println("Сканирую страницу № "+j+" документа "+sd.getName());
            }
            System.out.println("Документ "+sd.getName()+" отсканирован");
        }
        notify();
        isPrinted = false;

    }
}
