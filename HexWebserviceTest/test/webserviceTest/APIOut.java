package webserviceTest;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.rpc.ServiceException;

import org.apache.axis.utils.StringUtils;

import tangdi.ws.service.HexingWs;
import tangdi.ws.service.HexingWsService;
import tangdi.ws.service.HexingWsServiceLocator;

public class APIOut
{
  public static void main(String[] args)
    throws RemoteException
  {
    System.out.println(payPower());
	 System.out.println(meterQuery());//表计信息查询  OK 
//	 System.out.println(meterPayInfo());//表计购电记录  OK
//	 System.out.println(meterPayDetail());//购电详情 OK
//	 System.out.println(accountPayInfo());//代理商购电记录   OK
//	 System.out.println(accountEarning());//代理商收支明细  OK
//	 System.out.println(queryBalance());//查询余额 OK
//	 System.out.println(payPower());//购电 OK

  }

  public static String meterQuery() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("ENEL_ID", "Y2015020700043");
    paramMap.put("METER_NO", "07042464888");
    paramMap.put("SIGN_TYPE", "1");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    String str = conn(
      "IQAmmeter",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><ENEL_ID>Y2015020700043</ENEL_ID><METER_NO>07042464888</METER_NO></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
    return str;
  }

  public static String meterPayInfo() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("METER_NO", "07060093957");
    paramMap.put("SIGN_TYPE", "1");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    return conn(
      "IQAgentAPayPInf",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><METER_NO>07060093957</METER_NO></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
  }

  public static String meterPayDetail() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("SIGN_TYPE", "1");
    paramMap.put("PRDORDNO", "D015041400000841");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    return conn(
      "IQAgentPPDetail",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><PRDORDNO>D015041400000841</PRDORDNO></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
  }

  public static String accountPayInfo() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("SIGN_TYPE", "1");
    paramMap.put("ORDSTATUS", "00");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    return conn("IQAgentPPInf",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><ORDSTATUS>00</ORDSTATUS></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
  }

  public static String accountEarning() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("SIGN_TYPE", "1");
    paramMap.put("PRDORDNO", "D015043000000916");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    return conn("IQAgentEarning",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><PRDORDNO>D015043000000916</PRDORDNO></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
  }

  public static String queryBalance() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("SIGN_TYPE", "1");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    String str = conn("IAgentBalance",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
    return str;
  }

  public static String payPower() throws RemoteException {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatDateStr = formatter.format(currentTime);
    TreeMap paramMap = new TreeMap();
    paramMap.put("VERSION", "1.0");
    paramMap.put("SOURCE", "0");
    paramMap.put("CUST_ID", "A0000000000166");
    paramMap.put("REQUEST_TIME", formatDateStr);
    paramMap.put("SIGN_TYPE", "1");
    paramMap.put("USER_ID", "admin");
    paramMap.put("POWER_AMT", "2000.00");
    paramMap.put("METER_NO", "07042464888");
    paramMap.put("ENEL_ID", "Y2015020700043");
    paramMap.put("PAY_PWD", "td888888");
    String signStr = bulidParam(paramMap);
    String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
    System.out.println("Sign:" + sign);
    String str = conn("IPayPower",
      "<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000000166</CUST_ID><REQUEST_TIME>" +
      formatDateStr + "</REQUEST_TIME></TOP>" +
      "<BODY><USER_ID>admin</USER_ID><POWER_AMT>2000.00</POWER_AMT><METER_NO>07042464888</METER_NO><ENEL_ID>Y2015020700043</ENEL_ID><PAY_PWD>td888888</PAY_PWD></BODY>" +
      "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>" + sign + "</SIGNATURE></TAIL>" +
      "</ROOT>");
    return str;
  }

  public static String conn(String method, String reqxml)
    throws RemoteException
  {
    HexingWsService service = new HexingWsServiceLocator();
    HexingWs client = null;
    try {
      client = service.getHexingWsPort();
    } catch (ServiceException e) {
      e.printStackTrace();
    }
    String str = null;
    try {
      str = client.trans(method, reqxml);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return str;
  }
	public static String bulidParam(TreeMap paramMap) {
		String str = "";
		Set<Map.Entry<String, String>> set = paramMap.entrySet();
		for (Map.Entry<String, String> entry : set) {
			if(!StringUtils.isEmpty(entry.getValue())){
			str += (entry.getKey().toUpperCase() + "=" + entry.getValue() + "&");
			}
		}
		str += "KEY=82x6ZhAQcufp";//IMkXpbUVhvTI
		System.out.println("Sign str:"+str);
		return str;
	}
}