package cn.multithreading.sts1test;

import cn.multithreading.sts1test.encryptionws.GetBoxInfoSTS6;
import cn.multithreading.sts1test.encryptionws.GetBoxInfoSTS6Response;

import java.util.regex.Pattern;

/**
 * 验证乌干达STS1加密服务，极少出现Token位数不对的情况，目的使用多线程复现这个问题
 * 右击encryptionws选择最后webservice，使用wsdl地址生成客户端代码（webservice platform选择glassfish...，其他的都需要安装插件）
 * 这里导的是Centlec。STS2的wsdl：http://192.168.80.35:8010/EncrptionService/ws/EncrptionService?wsdl
 */
public class MainTest {
    // 加密服务地址
//    private static String sts1Url = "http://localhost:8080/EncrptionService/EncrptionService?wsdl";
    private static String sts1Url = "http://192.168.80.35:8010/EncrptionService/ws/EncrptionService?wsdl";
    private static String patternStr = "^[0-9]{20}$";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(patternStr);
        GetBoxInfoSTS6 info = new GetBoxInfoSTS6();
        GetBoxInfoSTS6Response infoResult = new GetBoxInfoSTS6Response();
        System.out.println(infoResult.getBoxId());
//        IEncryptionEngine sts1Engine = createService(sts1Url);
//        int size = 20000;
//        Request1 request1 = new Request1(sts1Engine, pattern, size);
//        Request2 request2 = new Request2(sts1Engine, pattern, size);
//        Request3 request3 = new Request3(sts1Engine, pattern, size);
//        Request4 request4 = new Request4(sts1Engine, pattern, size);
//        Request5 request5 = new Request5(sts1Engine, pattern, size);
//        new Thread(request1, "线程1").start();
//        new Thread(request2, "线程2").start();
//        new Thread(request3, "线程3").start();
//        new Thread(request4, "线程4").start();
//        new Thread(request5, "线程5").start();
    }


    // 获取加密服务RPC，与eclipse生成的java代码不同，没有locator
//    private static IEncryptionEngine createService(String url) {
//        try {
//            return new EncryptionEngineServiceLocator().getEncryptionEnginePort(new URL(sts1Url));
//        } catch (MalformedURLException | ServiceException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
