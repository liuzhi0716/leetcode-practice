package com.ecnu.liu.algorithm.concurrent;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.concurrent
 * @date: Created in 2020-03-02
 * @modified By:
 */
public class Practice0 {


    public static void main (String[] args) {
        Integer i = 5;
        Thread a = new Thread(() -> {
            synchronized (i) {
                for (int j = 0; j < 26; j++) {
                    int c = 'a' + j;
                    System.out.println((char) c);
                    i.notify();
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            synchronized (i) {
                for (int j = 0; j < 26; j++) {
                    System.out.println(j);
                    i.notify();
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        a.start();
        b.start();
    }
}
