package woa.vincent.aboutVolatileSynchronize;

/**
 * 使用了volatile
 */
public class VolatileDemo {
    public static volatile boolean stop = false;    //任务是否停止，volatile变量

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(()->{
            while (!stop) {
                //do someting
            }
            System.out.println("stop=true，满足停止条件。子线程停止时间：" + System.currentTimeMillis());
        });
        thread1.start();

        // 主线程在子线程启动后执行，修改stop=true，子线程立马察觉到这个变化。若无volatile则察觉不到
        Thread.sleep(100);
        stop = true;
        System.out.println("主线程设置停止标识 stop=true。设置时间：" + System.currentTimeMillis());
    }
}
