package xmlvendTest;

import cn.vincent.xmlvend.client.*;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

public class xmlvendOut {
    public static void main(String[] args) throws MalformedURLException, NRSFaultResponseSoapOut {
        System.out.println(conn());
    }



    public static LoginUser conn() throws MalformedURLException, NRSFaultResponseSoapOut {
        XMLVendService21 xmlvend = new XMLVendService21();
        XMLVendServiceSoap soapObj = xmlvend.getXMLVendServicePort();
        // 准备请求参数
        LoginReq loginReq = new LoginReq();
        // 1-client ID
        EANDeviceID deviceID = new EANDeviceID();
        deviceID.setEan("0000000000001");
        loginReq.setClientID(deviceID);
        // 2-terminalID
        GenericDeviceID genericDeviceID = new GenericDeviceID();
        genericDeviceID.setId("000098");
        loginReq.setTerminalID(genericDeviceID);
        // 3-msgId
        MsgID msgId = new MsgID();
        msgId.setDateTime("20191126090312");
        msgId.setUniqueNumber(new BigInteger("972238"));
        loginReq.setMsgID(msgId);
        // 4-authCred
        AuthCred authCred = new AuthCred();
        authCred.setOpName("AG0000001");
        authCred.setPassword("CENT123456");
        loginReq.setAuthCred(authCred);
        // 发送请求
        LoginUser loginUser = soapObj.loginRequest(loginReq);
        return loginUser;
    }
}
