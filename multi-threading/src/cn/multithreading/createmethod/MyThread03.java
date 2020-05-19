package cn.multithreading.createmethod;

import java.util.concurrent.Callable;

/**
 * 有返回值的情况：Callable
 */
public class MyThread03 implements Callable {
    private String callResult;

    public MyThread03(String callResult) {
        this.callResult = callResult;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        return callResult;
    }
}
