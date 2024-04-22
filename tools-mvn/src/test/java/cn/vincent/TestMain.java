package cn.vincent;

import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
        Random random = new Random(10);
        System.out.println(random.nextInt(1000));
    }
}
