package xmlvendTest;

import cn.vincent.xmlvend.client.*;

import javax.net.ssl.SSLSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * 需要信任服务端证书先，否则报：unable to find valid certification path to requested target
 * 【1-先查看】keytool -list -keystore cacerts
 * 无密码也可以查看/changeit，提示这是jks文件类似trust_store，包含104个条目
 * 【2-导入服务端证书】keytool -import -alias server_cert -keystore cacerts -file D://java//jdk1.8.0_131//jre//lib//security//server_cert.cer
 * 输入密码changeit，输入y，将CentlecXMLVend服务器公钥证书添加到cacerts
 * 【3-再查看导入的证书】keytool -list -keystore cacerts -alias server_cert
 * 输入密码changeit
 */
public class XmlvendOut {
    // xmlvend服务
    private static XMLVendService21 xmlvend = new XMLVendService21();
    private static XMLVendServiceSoap soapObj = xmlvend.getXMLVendServicePort();
    // 公共参数
    // 1-client ID
    private static EANDeviceID deviceID = new EANDeviceID();
    // 2-terminalID
    private static GenericDeviceID genericDeviceID = new GenericDeviceID();
    // 3-msgId
    private static MsgID msgId = new MsgID();
    // 4-authCred
    private static AuthCred authCred = new AuthCred();
    // 5-idMethod
    private static VendIDMethod vendIDMethod = new VendIDMethod();
    // 6-购买金额
    private static PurchaseValueCurrency purchaseValueCurrency = new PurchaseValueCurrency();
    // 证书相关
    static{
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){
                    @Override
                    public boolean verify(String hostname, SSLSession sslSession) {
                        if(hostname.equals("192.168.80.35")){
                            return true;
                        }
                        return false;
                    }
                }
        );
        System.setProperty("javax.net.ssl.keyStore", "D:\\Java\\jdk1.8.0_131\\jre\\lib\\security\\simon3650.pfx");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
    }

    /**
     * 初始化公共参数
     */
    private static void initPublicParam(){
        deviceID.setEan("0000000000003");
        genericDeviceID.setId("0000000000003");
        msgId.setDateTime("20200830000001");
        msgId.setUniqueNumber(new BigInteger("111111"));
        authCred.setOpName("AG0003");
        authCred.setPassword("CENT123456");
        // 表号对象
        MeterNumber meterNumber = new MeterNumber();
        meterNumber.setMsno("07040904562");
        vendIDMethod.setMeterIdentifier(meterNumber);
        // 金额对象
        Currency currency = new Currency();
        currency.setValue(new BigDecimal("20"));
        currency.setSymbol("R");
        purchaseValueCurrency.setAmt(currency);
    }

    public static LoginUser loginReq() throws NRSFaultResponseSoapOut {
        LoginReq loginReq = new LoginReq();
        loginReq.setClientID(deviceID);
        loginReq.setTerminalID(genericDeviceID);
        loginReq.setMsgID(msgId);
        loginReq.setAuthCred(authCred);
        return soapObj.loginRequest(loginReq);
    }
    public static ConfirmCustomerResp confirmCustomerReq() throws NRSFaultResponseSoapOut {
        ConfirmCustomerReq confirmCustomerReq = new ConfirmCustomerReq();
        confirmCustomerReq.setClientID(deviceID);
        confirmCustomerReq.setTerminalID(genericDeviceID);
        confirmCustomerReq.setMsgID(msgId);
        confirmCustomerReq.setAuthCred(authCred);
        confirmCustomerReq.setIdMethod(vendIDMethod);
        return soapObj.confirmCustomerRequest(confirmCustomerReq);
    }
    public static CreditVendResp creditVendReq() throws NRSFaultResponseSoapOut {
        CreditVendReq creditVendReq = new CreditVendReq();
        creditVendReq.setClientID(deviceID);
        creditVendReq.setTerminalID(genericDeviceID);
        creditVendReq.setMsgID(msgId);
        creditVendReq.setAuthCred(authCred);
        creditVendReq.setIdMethod(vendIDMethod);
        creditVendReq.setPurchaseValue(purchaseValueCurrency);
        return soapObj.creditVendRequest(creditVendReq);
    }
    public static AdviceResp adviceReq() throws NRSFaultResponseSoapOut {
        LastRespAdviceReq adviceReq = new LastRespAdviceReq();
        adviceReq.setClientID(deviceID);
        adviceReq.setTerminalID(genericDeviceID);
        adviceReq.setMsgID(msgId);
        adviceReq.setAuthCred(authCred);
        adviceReq.setAdviceReqMsgID(msgId);
        return soapObj.adviceRequest(adviceReq);
    }
    public static ReprintResp reprintReq() throws NRSFaultResponseSoapOut {
        ReprintReq reprintReq = new ReprintReq();
        reprintReq.setClientID(deviceID);
        genericDeviceID.setId("R202008,202008");
        reprintReq.setTerminalID(genericDeviceID);
        reprintReq.setMsgID(msgId);
        reprintReq.setAuthCred(authCred);
        reprintReq.setIdMethod(vendIDMethod);
        return soapObj.reprintRequest(reprintReq);
    }


    public static void main(String[] args) {
        initPublicParam();
//        showLogin();
//        showCustomer();
//        showVend();
//        showAdvice();
        showReprint();
    }

    public static void showLogin(){
        LoginUser loginUser = null;
        try {
            loginUser = loginReq();
        } catch (NRSFaultResponseSoapOut nrsFaultResponseSoapOut) {
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getFaultCode());
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getDesc());
        }
        System.out.println("CDUName:" + loginUser.getCDUName());
        System.out.println("Balance:" + loginUser.getCDUBalance());
    }
    public static void showCustomer(){
        ConfirmCustomerResp confirmCustomerResp = null;
        try {
            confirmCustomerResp = confirmCustomerReq();
        } catch (NRSFaultResponseSoapOut nrsFaultResponseSoapOut) {
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getFaultCode());
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getDesc());
        }
        System.out.println("CustomerNo:" + confirmCustomerResp.getConfirmCustResult().get(0).getCustVendDetail().getAccNo());
        System.out.println("CustomerName:" + confirmCustomerResp.getConfirmCustResult().get(0).getCustVendDetail().getName());
        System.out.println("CustomerAddress:" + confirmCustomerResp.getConfirmCustResult().get(0).getCustVendDetail().getAddress());
        System.out.println("CustomerTariff:" + confirmCustomerResp.getConfirmCustResult().get(0).getCustVendDetail().getLocRef());
        System.out.println("FBE:" + confirmCustomerResp.getConfirmCustResult().get(0).getCustVendConfig().isFbeDue());
        System.out.println("meter:" + confirmCustomerResp.getConfirmCustResult().get(0).getMeterDetail().getMsno());
        System.out.println("sgc:" + confirmCustomerResp.getConfirmCustResult().get(0).getMeterDetail().getSgc());
    }
    public static void showVend(){
        CreditVendResp creditVendResp = null;
        try {
            creditVendResp = creditVendReq();
        } catch (NRSFaultResponseSoapOut nrsFaultResponseSoapOut) {
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getFaultCode());
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getDesc());
        }
        System.out.println("ReceiptNo:" + creditVendResp.getCreditVendReceipt().getReceiptNo());
        CreditVendTx creditVendTx = (CreditVendTx) creditVendResp.getCreditVendReceipt().getTransactions().getTx().get(0);
        System.out.println("meter:" + creditVendTx.getCreditTokenIssue().getMeterDetail().getMsno());
        System.out.println("sgc:" + creditVendTx.getCreditTokenIssue().getMeterDetail().getSgc());
        System.out.println("KC_TOKEN:" + creditVendTx.getKcTokenIssue());
        STS1Token sts1Token = (STS1Token) creditVendTx.getCreditTokenIssue().getToken();
        System.out.println("TOKEN:" + sts1Token.getStsCipher());
        System.out.println("amt:" + creditVendTx.getAmt().getValue());
        System.out.println("units:" + creditVendTx.getCreditTokenIssue().getUnits().getValue());
        System.out.println("tariff:" + creditVendTx.getTariff().getName());
    }
    public static void showAdvice(){
        LastRespAdviceResp adviceResp = null;
        try {
            adviceResp = (LastRespAdviceResp) adviceReq();
        } catch (NRSFaultResponseSoapOut nrsFaultResponseSoapOut) {
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getFaultCode());
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getDesc());
        }
        CreditVendResp creditVendResp = (CreditVendResp) adviceResp.getLastResponse();
        System.out.println("ReceiptNo:" + creditVendResp.getCreditVendReceipt().getReceiptNo());
        CreditVendTx creditVendTx = (CreditVendTx) creditVendResp.getCreditVendReceipt().getTransactions().getTx().get(0);
        System.out.println("meter:" + creditVendTx.getCreditTokenIssue().getMeterDetail().getMsno());
        System.out.println("sgc:" + creditVendTx.getCreditTokenIssue().getMeterDetail().getSgc());
        System.out.println("KC_TOKEN:" + creditVendTx.getKcTokenIssue());
        STS1Token sts1Token = (STS1Token) creditVendTx.getCreditTokenIssue().getToken();
        System.out.println("TOKEN:" + sts1Token.getStsCipher());
        System.out.println("amt:" + creditVendTx.getAmt().getValue());
        System.out.println("units:" + creditVendTx.getCreditTokenIssue().getUnits().getValue());
        System.out.println("tariff:" + creditVendTx.getTariff().getName());
    }
    public static void showReprint(){
        ReprintResp reprintResp = null;
        try {
            reprintResp = reprintReq();
        } catch (NRSFaultResponseSoapOut nrsFaultResponseSoapOut) {
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getFaultCode());
            System.out.println(nrsFaultResponseSoapOut.getFaultInfo().getFault().getDesc());
        }
        System.out.println("total:" + reprintResp.getReprint().size());
        if(reprintResp.getReprint() != null && reprintResp.getReprint().size() > 0){
            for (BaseVendResp tx : reprintResp.getReprint()) {
                CreditVendResp creditTx = (CreditVendResp) tx;
                System.out.println("ReceiptNo:" + creditTx.getCreditVendReceipt().getReceiptNo());
            }
        }
    }
}
