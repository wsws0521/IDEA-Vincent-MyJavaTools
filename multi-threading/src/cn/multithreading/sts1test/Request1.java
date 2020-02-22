package cn.multithreading.sts1test;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Request1 implements Runnable {
    int sequence = 0;
    int size;

//    IEncryptionEngine sts1Engine;
//    Object[] tokenArray;
//    Pattern pattern;
//
//    public Request1(IEncryptionEngine sts1Engine, Pattern pattern, int size) {
//        this.sts1Engine = sts1Engine;
//        this.pattern = pattern;
//        this.size = size;
//        this.tokenArray = new Object[size];
//    }
//    long meterNo = 6670050753l;
//    int supplyGroupCode = 990458;
//    int tarrifIndex = 1;
//    int keyVersion = 1;
//    int keyExpired = 255;
//    BigDecimal transferAmount = new BigDecimal("1197");
//    int creditFunction = 0;
//    ObjectArrayHolder makeTokenResult = new ObjectArrayHolder();
//    IntegerWrapperHolder errorCode = new IntegerWrapperHolder();


    @Override
    public void run() {
//        long startTime = System.currentTimeMillis();
//        while(sequence < size) {
//            try {
//                sts1Engine.makeToken(meterNo, supplyGroupCode, tarrifIndex, keyVersion, keyExpired, transferAmount, creditFunction, makeTokenResult, errorCode);
//                tokenArray[sequence] = makeTokenResult.value[0];
//                sequence++;
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName() + "运行时间：" + (endTime - startTime) + "ms");
//        this.validate();
    }

//    private void validate() {
//        System.out.println("错误的Token：");
//        for(Object token : tokenArray) {
//            if(!pattern.matcher(token.toString()).matches()) {
//                System.out.println(token.toString());
//            }
//        }
//    }

}
