package cn.multithreading.aboutVolatileSynchronize;

/**
 * 用在方法上，效率低一点
 */
public class SynchronizedTest {
    public int race = 0;

    // 使用synchronized保证++操作原子性
    public synchronized void increase() {
        race++;
    }

    public int getRace() {
        return race;
    }


    public static void main(String[] args) {
        // 创建5个线程，同时对同一个volatileTest实例对象执行累加操作
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];//5个线程
        for (int i = 0; i < threadCount; i++) {
            // 每个线程都执行1000次++操作
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronizedTest.increase();
                }
                System.out.println(synchronizedTest.getRace());
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //所有子线程结束后，race是：5*10000=50000。
        System.out.println("累加结果：" + synchronizedTest.getRace());
    }
}
