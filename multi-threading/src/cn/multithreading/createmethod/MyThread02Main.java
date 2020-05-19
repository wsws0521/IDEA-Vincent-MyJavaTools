package cn.multithreading.createmethod;

public class MyThread02Main {
    public static void main(String[] args) {
        MyThread02 myThread02 = new MyThread02();
        Thread thread = new Thread(myThread02);
        thread.start(); // Thread的run会直接调用myThread02的run
    }
}
