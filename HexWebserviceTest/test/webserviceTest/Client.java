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
//		 System.out.println(Login());//��¼
//		 System.out.println(PUpdateAndVerifyTime());//�汾����
//		System.out.println(PNotifyQuery());//�����ѯ
//		 System.out.println(PBillQuery());//�շѲ�ѯ
//		 System.out.println(PBillFeeCount());//�۵����Ѽ���
//		 System.out.println(PBillReprintQuery());//ƾ֤��ѯ
//		 System.out.println(PBillReprint());//ƾ֤����
//		 System.out.println(PBillRecoveryQuery());//�շѼ�¼��ѯ��������ѯ��
//		 System.out.println(PBillReversalApp());//��������
//		System.out.println(PBillDailyQuery());//�ս��ѯ
//		System.out.println(PBillDailyConfirm());//�սᴦ��
//		System.out.println(PBillDailyApply());//�����ս�
//		System.out.println(PBillBuy());//�����շ�
		System.out.println(PBillPay());//�˵��շ�
		 
	}

	public static String Login() throws RemoteException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDateStr=formatter.format(currentTime);
		String str = conn(//��¼
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
		String str = conn(//�汾����
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
		String str = conn(//�����ѯ
				"PNotifyQuery",
				"<ROOT>"
				+ "<TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><IMEI>862845024199122</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
				+ "<BODY></BODY>"
				+ "</ROOT>");
		return str;
	}
	//�շѲ�ѯ
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
			String str = conn(//�շѲ�ѯ
					"PBillQuery",
					"<ROOT>"
					+  "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><METER_NO>1031204402</METER_NO><PAGENUM>1</PAGENUM></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//�۵����Ѽ���
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
				String str = conn(//�۵����Ѽ���
						"PBillFeeCount",
						"<ROOT>"
						+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
						+ "<BODY><AMT>2000</AMT></BODY>"
						+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
						+ "</ROOT>");
				return str;
		}
		//ƾ֤��ѯ
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
						String str = conn(//ƾ֤��ѯ��ѯ
								"PBillReprintQuery",
								"<ROOT>"
								+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
								+ "<BODY><METER_NO>1031204425</METER_NO><PAGENUM>1</PAGENUM><NUMPERPAG>3</NUMPERPAG></BODY>"
								+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
								+ "</ROOT>");
						return str;
				}
				//ƾ֤��ѯ
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
						String str = conn(//ƾ֤����
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
			String str = conn(//�շѼ�¼��ѯ��������
					"PBillRecoveryQuery",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><USER_NO>1031204462</USER_NO><PAGENUM>1</PAGENUM><NUMPERPAG>5</NUMPERPAG></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
//	��������
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
			String str = conn(//��������
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
			String str = conn(//��֧��ϸ
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
			String str = conn(//�ս��ѯ
					"PBillDailyQuery",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><STATUS>0</STATUS></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//�սᴦ��
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
			String str = conn(//�սᴦ��
					"PBillDailyConfirm",
					"<ROOT>"
					+ "<TOP><IMEI>762845024199122</IMEI><SESSION_ID>7mL1dE0xBIA3nn57cF61</SESSION_ID><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>zh</LOCAL_LANGUAGE></TOP>"
					+ "<BODY><TOF_NO>T015102900000226</TOF_NO><STATUS>0</STATUS></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			return str;
	}
	//�����ս�
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
				String str = conn(//�����ս�
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
			
			paramMap.put("RECE_ID", "32015102818050013");   //�˵��շѡ���Ӧ���˿�ID
			paramMap.put("AMT", "428.700");   //�˵��շѡ����շѽ��
			
			String signStr = bulidParam(paramMap);
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println(
					"<ROOT>"   //�˵��շ�
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><RECE_ID>32015102818050013</RECE_ID><AMT>428.700</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			String str = conn(
					"PBillPay",
					"<ROOT>"   //�˵��շ�
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

			paramMap.put("AMT", "3000");   //�۵��շѡ������
			paramMap.put("METER_NO", "07042464888");   //�۵��շѡ������
		
			String signStr = bulidParam(paramMap);
			String sign = Md5Algorithm.getInstance().md5Digest(signStr.getBytes());
			System.out.println(
					"<ROOT>"   
					+ "<TOP><IMEI>152845024129178</IMEI><REQUEST_TIME>"+formatDateStr+"</REQUEST_TIME><LOCAL_LANGUAGE>en</LOCAL_LANGUAGE><SESSION_ID>LKc4YzXCsqvnt7aqDTHl</SESSION_ID></TOP>"
					+ "<BODY><METER_NO>07042464888</METER_NO><AMT>3000</AMT></BODY>"
					+ "<TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>"+sign+"</SIGNATURE></TAIL>"
					+ "</ROOT>");
			String str = conn(
					"PBillBuy",  //�۵��շ�
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
