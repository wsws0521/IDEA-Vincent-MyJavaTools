package cn.multithreading.createmethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    private Lock lock = new ReentrantLock();
    private Condition condition=lock.newCondition();//创建Condition

    public void testMethod() {
        try {
            lock.lock();//lock加锁
            //1：wait 方法等待：
            //System.out.println("开始wait");
            condition.await();
            //通过创建Condition对象来使线程wait，必须先执行lock.lock方法获得锁
            //:2：signal方法唤醒
            condition.signal();//condition对象的signal方法可以唤醒wait线程
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

