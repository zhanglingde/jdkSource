package com.ling.test.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangling  2021/9/4 10:31
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();

    public static void m1(){
        lock.lock();
        try{
            System.out.println("hello");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m1();

    }
}
