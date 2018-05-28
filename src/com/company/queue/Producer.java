package com.company.queue;

public class Producer implements Runnable{
    QueueGood q;

    public Producer(QueueGood q){
        this.q = q;
        new Thread(this,"Поставшик").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            q.put(i++);
        }
    }
}
