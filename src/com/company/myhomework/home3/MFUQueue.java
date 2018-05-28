package com.company.myhomework.home3;

import java.lang.reflect.Array;

public class MFUQueue<T extends Document> {
    private T[] arr;
    private int count;

    public MFUQueue(Class clazz, int count) {
        arr =  (T[])Array.newInstance(clazz, count);
        this.count = 0;
    }

    public synchronized void add(T item) {
        System.out.println("Поток № " + Thread.currentThread().getName() + " добавил в очередь элемент " + item.getName());
        arr[count] = item;
        count++;
    }

    public synchronized T get(int index){
        return arr[index];
    }

    public int size(){
        return count+1;
    }

}
