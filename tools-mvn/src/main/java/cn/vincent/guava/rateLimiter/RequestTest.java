package cn.vincent.guava.rateLimiter;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 令牌桶算法
 */
public class RequestTest {
    public static void main(String[] args) throws IOException {
        HelloService helloService = new HelloService();
        CountDownLatch latch = new CountDownLatch(1);
        Random random = new Random(10);
        // 启动 20 个线程，先阻塞待命
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(()->{
                try {
                    latch.await();
                    Thread.sleep(random.nextInt(1000));
                    helloService.doRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        // 这个类使一个线程等待其他线程各自执行完毕后再执行
        latch.countDown();
        // 保持main不停止
        System.in.read();
    }
}
