package com.company.queue;

public class Consumer implements Runnable {
    QueueGood q;

    public Consumer(QueueGood q){
        this.q = q;
        new Thread(this, "Получатель").start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}
