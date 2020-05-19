package cn.multithreading.createmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyThread03Main {
    private static final int taskSize = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyThread03(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池（就像开关DB连接，浪费资源）
        pool.shutdown();
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
    }
}
