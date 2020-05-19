package cn.multithreading.createmethod;

/**
 * 如果已经是儿子了，Java的单父，无法再继承Thread，只能实现接口
 */
public class MyThread02 extends MyThread02Base implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("MyThread.runnable()");
    }
}
