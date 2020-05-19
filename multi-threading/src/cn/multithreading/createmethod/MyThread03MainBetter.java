package cn.multithreading.createmethod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程和数据库连接这些资源都是非常宝贵的资源。
 * 那么每次需要的时候创建，不需要的时候销 毁，是非常浪费资源的。
 * 那么我们就可以使用缓存的策略，也就是使用线程池
 */
public class MyThread03MainBetter {
    private static final int taskSize = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        while(true){
            pool.execute(
                    new Runnable() {    // 提交多个线程任务，并执行
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + " is running ..");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );
        }
    }
}
