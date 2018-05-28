package com.company.queue;

public class ConsumerProducerApp {
    public static void main(String[] args) {
        QueueGood q = new QueueGood();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
}
