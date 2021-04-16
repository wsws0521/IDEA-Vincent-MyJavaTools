package tool.vincent.testGC;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 运行
 * 打开 jvisualvm
 */
public class TestGc {
    byte[] a = new byte[1024 * 100]; // 100kb
    public static void main(String[] args) throws InterruptedException {
        ArrayList<TestGc> testGcList = new ArrayList<>();
        while (true){
            testGcList.add(new TestGc());
            Thread.sleep(10);
        }
//        SynchronizedHashMap
    }
}
