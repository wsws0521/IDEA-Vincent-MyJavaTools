package webserviceTest;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.rpc.ServiceException;

import org.apache.axis.utils.StringUtils;

import tangdi.ws.service.HexingWs;
import tangdi.ws.service.HexingWsProxy;
import tangdi.ws.service.HexingWsService;
import tangdi.ws.service.HexingWsServiceLocator;

public class Client {
	public static void main(String[] args) throws RemoteException {
//		 System.out.println(Login());//登录
//		 System.out.println(PUpdateAndVerifyTime());//版本更新
//		System.out.println(PNotifyQuery());//公告查询
//		 System.out.println(PBillQuery());//收费查询
//		 System.out.println(PBillFeeCount());//售电服务费计算
//		 System.out.println(PBillReprintQuery());//凭证查询
//		 System.out.println(PBillReprint());//凭证补打
//		 System.out.println(PBillRecoveryQuery());//收费记录查询（冲正查询）
//		 System.out.println(PBillReversalApp());//冲正申请
//		System.out.println(PBillDailyQuery());//日结查询
//		System.out.println(PBillDailyConfirm());//日结处理
//		System.out.println(PBillDailyApply());//发起日结
//		System.out.println(PBillBuy());//购电收费
		System.out.println(PBillPay());//账单收费
		 
	}

	public static String Login() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		String str = conn(//登录
				"PLogin",
				"<ROOT>"
				+ "<TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><IMEI>762845024199122</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
				+ "<BODY><OPER_ID>admin</OPER_ID><SYS_PID>1031204498</SYS_PID><LOGIN_PWD>9f91a454c218b386ee872d7458a934f3</LOGIN_PWD></BODY>"
				+ "</ROOT>");
		return str;
	}
	public static String PUpdateAndVerifyTime() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		String str = conn(//版本更新
				"PUpdateAndVerifyTime",
				"<ROOT>"
				+ "<TOP><VERSION>1000</VERSION><SOURCE>0</SOURCE><IMEI>762845024199122</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
				+ "<BODY><TEMP_VERSION>0</TEMP_VERSION></BODY>"
				+ "</ROOT>");
		return str;
	}
	public static String PNotifyQuery() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		String str = conn(//公告查询
				"PNotifyQuery",
				"<ROOT>"
				+ "<TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><IMEI>862845024199122</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
				+ "<BODY></BODY>"
				+ "</ROOT>");
		return str;
	}
	//收费查询
	public static String PBillQuery() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "762845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "en");
			paramMap.put("SIGN_TYPE", "1");
			paramMap.put("METER_NO", "1031204402");
			paramMap.put("PAGENUM", "1");
//			paramMap.put("NUMPERPAG", "3");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println("SIGN: "+sign);
			String str = conn(//收费查询
					"PBillQuery",
					"<ROOT>"
					+  "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><METER_NO>1031204402</METER_NO><PAGENUM>1</PAGENUM></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//售电服务费计算
		public static String PBillFeeCount() throws RemoteException {
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDateStr=formatter.format(currentTime);
			 TreeMap<String, String> paramMap = new TreeMap<String, String>();
				paramMap.put("IMEI", "762845024199122");
				paramMap.put("REQUEST_TIME", formatDateStr);
				paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
				paramMap.put("LOCAL_LANGUAGE", "zh");
				paramMap.put("SIGN_TYPE", "1");
				paramMap.put("AMT", "2000");
				String signStr = bulidParam(paramMap);//key
				String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
				System.out.println("SIGN: "+sign);
				String str = conn(//售电服务费计算
						"PBillFeeCount",
						"<ROOT>"
						+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
						+ "<BODY><AMT>2000</AMT></BODY>"
						+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
						+ "</ROOT>");
				return str;
		}
		//凭证查询
				public static String PBillReprintQuery() throws RemoteException {
					Date currentTime = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formatDateStr=formatter.format(currentTime);
					 TreeMap<String, String> paramMap = new TreeMap<String, String>();
						paramMap.put("IMEI", "762845024199122");
						paramMap.put("REQUEST_TIME", formatDateStr);
						paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
						paramMap.put("LOCAL_LANGUAGE", "zh");
						paramMap.put("SIGN_TYPE", "1");
						paramMap.put("METER_NO", "1031204425");
						paramMap.put("PAGENUM", "1");
						paramMap.put("NUMPERPAG", "3");
						String signStr = bulidParam(paramMap);//key
						String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
						System.out.println("SIGN: "+sign);
						String str = conn(//凭证查询查询
								"PBillReprintQuery",
								"<ROOT>"
								+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
								+ "<BODY><METER_NO>1031204425</METER_NO><PAGENUM>1</PAGENUM><NUMPERPAG>3</NUMPERPAG></BODY>"
								+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
								+ "</ROOT>");
						return str;
				}
				//凭证查询
				public static String PBillReprint() throws RemoteException {
					Date currentTime = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formatDateStr=formatter.format(currentTime);
					 TreeMap<String, String> paramMap = new TreeMap<String, String>();
						paramMap.put("IMEI", "762845024199122");
						paramMap.put("REQUEST_TIME", formatDateStr);
						paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
						paramMap.put("LOCAL_LANGUAGE", "zh");
						paramMap.put("SIGN_TYPE", "1");
						paramMap.put("PRDORDNO", "D015102800015022");
						String signStr = bulidParam(paramMap);//key
						String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
						System.out.println("SIGN: "+sign);
						String str = conn(//凭证补打
								"PBillReprint",
								"<ROOT>"
								+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
								+ "<BODY><PRDORDNO>D015102800015022</PRDORDNO></BODY>"
								+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
								+ "</ROOT>");
						return str;
				}
				
	
	public static String PBillRecoveryQuery() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "762845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "zh");
			paramMap.put("SIGN_TYPE", "1");
			paramMap.put("USER_NO", "1031204462");
			paramMap.put("PAGENUM", "1");
			paramMap.put("NUMPERPAG", "5");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println("SIGN: "+sign);
			String str = conn(//收费记录查询（冲正）
					"PBillRecoveryQuery",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><USER_NO>1031204462</USER_NO><PAGENUM>1</PAGENUM><NUMPERPAG>5</NUMPERPAG></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
//	冲正申请
	public static String PBillReversalApp() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "762845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "zh");
			paramMap.put("SIGN_TYPE", "1");
			paramMap.put("PRDORDNO", "D015102900018058");
			paramMap.put("TYPE", "1");
			paramMap.put("REASON", "d");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println("SIGN: "+sign);
			String str = conn(//冲正申请
					"PBillReversalApp",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><TYPE>1</TYPE><REASON>d</REASON><PRDORDNO>D015102900018058</PRDORDNO></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	public static String PBillIncomeQuery() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "862845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "zh");
			paramMap.put("SIGN_TYPE", "1");
			paramMap.put("PAGENUM", "1");
			paramMap.put("NUMPERPAG", "10");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println("SIGN: "+sign);
			String str = conn(//收支明细
					"PBillIncomeQuery",
					"<ROOT>"
					+ "<TOP><IMEI>862845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><PAGENUM>1</PAGENUM><NUMPERPAG>10</NUMPERPAG></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	public static String PBillDailyQuery() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "762845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "zh");
			paramMap.put("SIGN_TYPE", "1");
//			paramMap.put("OPER_ID", "admin");
			paramMap.put("STATUS", "0");
//			paramMap.put("PAGENUM", "1");
//			paramMap.put("NUMPERPAG", "5");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			String str = conn(//日结查询
					"PBillDailyQuery",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><STATUS>0</STATUS></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//日结处理
	public static String PBillDailyConfirm() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		 TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "762845024199122");
			paramMap.put("REQUEST_TIME", formatDateStr);
			paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
			paramMap.put("LOCAL_LANGUAGE", "zh");
			paramMap.put("SIGN_TYPE", "1");
			paramMap.put("TOF_NO", "T015102900000226");
			paramMap.put("STATUS", "0");
			String signStr = bulidParam(paramMap);//key
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println("SIGN: "+sign);
			String str = conn(//日结处理
					"PBillDailyConfirm",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><TOF_NO>T015102900000226</TOF_NO><STATUS>0</STATUS></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//发起日结
		public static String PBillDailyApply() throws RemoteException {
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDateStr=formatter.format(currentTime);
			 TreeMap<String, String> paramMap = new TreeMap<String, String>();
				paramMap.put("IMEI", "762845024199122");
				paramMap.put("REQUEST_TIME", formatDateStr);
				paramMap.put("SESSION_ID","7mL1dE0xBIA3nn57cF61");
				paramMap.put("LOCAL_LANGUAGE", "zh");
				paramMap.put("SIGN_TYPE", "1");
				String signStr = bulidParam(paramMap);//key
				String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
				System.out.println("SIGN: "+sign);
				String str = conn(//发起日结
						"PBillDailyApply",
						"<ROOT>"
						+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
						+ "<BODY></BODY>"
						+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
						+ "</ROOT>");
				return str;
		}
		
		public static String PBillPay() throws RemoteException {
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDateStr=formatter.format(currentTime);
			TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "152845024129178");
			paramMap.put("REQUEST_TIME",formatDateStr);
			paramMap.put("LOCAL_LANGUAGE","en");
			paramMap.put("SESSION_ID","LKc4YzXCsqvnt7aqDTHl");
			paramMap.put("SIGN_TYPE", "1");
			
			paramMap.put("RECE_ID", "32015102818050013");   //账单收费——应收账款ID
			paramMap.put("AMT", "428.700");   //账单收费——收费金额
			
			String signStr = bulidParam(paramMap);
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println(
					"<ROOT>"   //账单收费
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><RECE_ID>32015102818050013</RECE_ID><AMT>428.700</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			String str = conn(
					"PBillPay",
					"<ROOT>"   //账单收费
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><RECE_ID>32015102818050013</RECE_ID><AMT>428.700</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
		}

		public static String PBillBuy() throws RemoteException {
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDateStr=formatter.format(currentTime);
			TreeMap<String, String> paramMap = new TreeMap<String, String>();
			paramMap.put("IMEI", "152845024129178");
			paramMap.put("REQUEST_TIME",formatDateStr);
			paramMap.put("LOCAL_LANGUAGE","en");
			paramMap.put("SESSION_ID","LKc4YzXCsqvnt7aqDTHl");
			paramMap.put("SIGN_TYPE", "1");

			paramMap.put("AMT", "3000");   //售电收费——金额
			paramMap.put("METER_NO", "07042464888");   //售电收费——表号
		
			String signStr = bulidParam(paramMap);
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println(
					"<ROOT>"   
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><METER_NO>07042464888</METER_NO><AMT>3000</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			String str = conn(
					"PBillBuy",  //售电收费
					"<ROOT>"   
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><METER_NO>07042464888</METER_NO><AMT>3000</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
		}
	public static String conn(String method, String reqxml)
			throws RemoteException {
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
		str += "KEY=751EA43CBFEB4E0336FB46CA95BE60B3";//IMkXpbUVhvTI
		System.out.println("Sign str:"+str);
		return str;
	}
}
