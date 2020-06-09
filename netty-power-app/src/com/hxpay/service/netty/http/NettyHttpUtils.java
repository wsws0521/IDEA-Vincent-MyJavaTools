package com.hxpay.service.netty.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.json.XML;
import org.xml.sax.InputSource;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class NettyHttpUtils {

	private String reqContent;
	private Map<String, String> map = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return map;
	}

	public NettyHttpUtils(String reqContent) {
		this.reqContent = reqContent;
	}

	public NettyHttpUtils() {
	}

	public String getParams(String key) {
		if (reqContent == null || reqContent == "") {
			return "";
		}

		return map.get(key);
	}

	// 处理http post请求，&分隔参数（手机个人版）
	public void initData() {
		if (reqContent == null || reqContent == "") {
			return;
		}
		// 包含多个参数
		if (reqContent.contains("&")) {
			String[] arr = reqContent.split("&");
			String string = "";
			for (int i = 0; i < arr.length; i++) {
				string = arr[i];
				if (string.contains("=")) {
					String key = URLDecoder.decode(string.substring(0,
							string.indexOf("=")));
					String value = URLDecoder.decode(string.substring(string
							.indexOf("=") + 1));
					map.put(key, value);
				} else {
					map.clear();
					break;
				}

			}

		} else {
			if (reqContent.contains("=")) {
				String key = URLDecoder.decode(reqContent.substring(0,
						reqContent.indexOf("=")));
				String value = URLDecoder.decode(reqContent
						.substring(reqContent.indexOf("=") + 1));
				map.put(key, value);
			} else {
				map.clear();
				return;
			}
		}

	}

	public JSONObject getJson(String str) {
		return (JSONObject) JSONSerializer.toJSON(str);

	}

	// 客户端请求json字符串转换为xml
	public static String jsontoXml(String json) {
		try {
			XMLSerializer serializer = new XMLSerializer();
			JSON jsonObject = JSONSerializer.toJSON(json);
			String orign = serializer.write(jsonObject);
			int start = orign.indexOf("<o>") + "<o>".length();
			int end = orign.indexOf("</o>");
			if (start < 0 || end < 0 || start > end) {
				return "";
			}
			String reqxml = orign.substring(start, end);
			reqxml = "<ROOT>" + reqxml + "</ROOT>";
			return reqxml;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String jsonArrayToXML(String json) {

		XMLSerializer xmlSerializer = new XMLSerializer();
		// 根节点名称
		xmlSerializer.setRootName("ROOT");
		// 不对类型进行设置
		xmlSerializer.setTypeHintsEnabled(false);
		String xmlStr = "";
		JSONObject jobj = JSONObject.fromObject(json);
		if(jobj==null){  
            return null;  
        }else{  
         Element elements=new Element("ROOT");  
         getXMLFromObject(jobj,"ROOT",elements);  
         XMLOutputter xmlOut = new XMLOutputter();    
         String res=xmlOut.outputString(elements);  
         xmlStr =  res;  
        }
		return xmlStr;
	}
	
	private static void getXMLFromObject(Object obj,String tag,Element parent)  
    {  
        if(obj==null)  
            return;  
        Element child;  
        String eleStr;  
        Object childValue;  
        if(obj instanceof JSONObject)  
        {  
            JSONObject jsonObject=(JSONObject)obj;  
            for(Object temp:jsonObject.keySet())  
            {  
                eleStr=temp.toString();  
                childValue=jsonObject.get(temp);  
                child=new Element(eleStr);  
                if(childValue instanceof JSONArray)  
                    getXMLFromObject(childValue,eleStr,parent);  
                else{  
                    parent.addContent(child);  
                    getXMLFromObject(childValue,eleStr,child);  
                }  
            }  
        }else if(obj instanceof JSONArray){  
            JSONArray jsonArray=(JSONArray)obj;  
            for(int i=0;i<jsonArray.size();i++)  
            {  
                childValue=jsonArray.get(i);  
                child=new Element(tag);  
                parent.addContent(child);  
                getXMLFromObject(childValue,tag,child);  
            }  
        }else if(obj instanceof Date){  
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            parent.setText(sf.format((Date)obj));  
        }else{  
            parent.setText(obj.toString());  
        }  
    }  

	public static String maptoXml(Map<String, String> map) {
		if (map.size() <= 0) {
			return "";
		}
		String xmlData = "";
		for (String key : map.keySet()) {
			String value = map.get(key);
			xmlData = xmlData + "<" + key + ">" + value + "</" + key + ">";
		}

		return "<xml>" + xmlData + "</xml>";
	}

	// 服务端返回xml转json
	public static String xmltoJson(String xml) {
		try {
			XMLSerializer xmlSerializer = new XMLSerializer();
			return xmlSerializer.read(xml).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Object getParam2(JSONObject data_null) {
		JSONObject data = data_null;
		Iterator it = data.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object temp = data.get(key);
			if (temp instanceof JSONObject) {
				JSONObject data_1 = (JSONObject) temp;
				getParam2(data_1);
				List aa = new ArrayList();
				aa.add(temp);
				data.put(key, aa);
			} else if (temp instanceof JSONArray) {
				JSONArray temp_a = (JSONArray) temp;
				for (int i = 0; i < temp_a.size(); i++) {
					JSONObject data_1 = temp_a.getJSONObject(i);
					getParam2(data_1);
				}
				data.put(key, temp);
			}
		}
		return data;
	}
	
	
	public static Object parseString(org.json.JSONObject data_null) {
		org.json.JSONObject data = data_null;
		Iterator it = data.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object temp = data.get(key);
			if (temp instanceof org.json.JSONObject) {
				org.json.JSONObject data_1 = (org.json.JSONObject) temp;
				getParam(data_1);
			} else if (temp instanceof org.json.JSONArray) {
				org.json.JSONArray temp_a = (org.json.JSONArray) temp;
				for (int i = 0; i < temp_a.length(); i++) {
					org.json.JSONObject data_1 = temp_a.getJSONObject(i);
					getParam(data_1);
				}
			} else if (!(temp instanceof String)) {
				String[] ints = new String[] { "PRDORDTYPE", "PWD_FLAG",
						"CARD_TYPE", "GOOD_TYPENO", "RATE_TYPE", "CAL_MODE",
						"MULTI_SECTION_MODE", "CUST_GRADE", "U_RULE",
						"VERSION_NO" };
				List<String> tempList = Arrays.asList(ints);
				if (!tempList.contains(key)){
					data.put(key, String.valueOf(temp));
				}
			}
		}
		return data;
	}

	public static Object getParam(org.json.JSONObject data_null) {
		org.json.JSONObject data = data_null;
		Iterator it = data.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object temp = data.get(key);
			if (temp instanceof org.json.JSONObject) {
				org.json.JSONObject data_1 = (org.json.JSONObject) temp;
				getParam(data_1);
				List aa = new ArrayList();
				aa.add(temp);
				data.put(key, aa);
			} else if (temp instanceof org.json.JSONArray) {
				org.json.JSONArray temp_a = (org.json.JSONArray) temp;
				for (int i = 0; i < temp_a.length(); i++) {
					org.json.JSONObject data_1 = temp_a.getJSONObject(i);
					getParam(data_1);
				}
				data.put(key, temp);
			} else if (!(temp instanceof String)) {
				String[] ints = new String[] { "PRDORDTYPE", "PWD_FLAG",
						"CARD_TYPE", "GOOD_TYPENO", "RATE_TYPE", "CAL_MODE",
						"MULTI_SECTION_MODE", "CUST_GRADE", "U_RULE",
						"VERSION_NO" };
				List<String> tempList = Arrays.asList(ints);
				if (!tempList.contains(key)){
					data.put(key, String.valueOf(temp));
				}
			}
		}
		return data;
	}

	public static org.json.JSONObject parseParamToString(org.json.JSONObject temp) {
		org.json.JSONObject data = temp;
		Iterator it = data.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			Object temp_v = data.get(key);
			if (temp_v instanceof Long) {
				data.put(key, String.valueOf(temp_v));
			} else if (temp_v instanceof org.json.JSONObject) {
				org.json.JSONObject data_1 = (org.json.JSONObject) temp_v;
				parseParamToString(data_1);
			} else if (temp_v instanceof org.json.JSONArray) {
				org.json.JSONArray temp_a = (org.json.JSONArray) temp_v;
				for (int i = 0; i < temp_a.length(); i++) {
					org.json.JSONObject data_1 = temp_a.getJSONObject(i);
					parseParamToString(data_1);
				}
			} else {
				data.put(key, String.valueOf(temp_v));
			}
		}
		return data;
	}

	public static String xmltoJson_O(String xml, String tran) {
		try {
			org.json.JSONObject xmlJSONObj = XML.toJSONObject(xml);
			org.json.JSONObject root = xmlJSONObj.getJSONObject("ROOT");
			parseString(root);
			if (root.has("DATA")) {
				Object data_null = root.get("DATA");
				if (data_null instanceof org.json.JSONObject) {
					org.json.JSONObject data = (org.json.JSONObject) data_null;
					getParam(data);
					if (data.has("DATA_1")) {
						Object temp = data.get("DATA_1");
						if (temp instanceof org.json.JSONObject) {
							List aa = new ArrayList();
							aa.add(temp);
							root.put("DATA", aa);
						} else if (temp instanceof org.json.JSONArray) {
							root.put("DATA", temp);
						}
					}
				}
			}

			String jsonPrettyPrintString = root.toString();
			return jsonPrettyPrintString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String xmltoJson_O2(String xml, String tran) {
		try {
			XMLSerializer xmlSerializer = new XMLSerializer();
			xml = xmlSerializer.read(xml).toString();

			// org.json.JSONObject xmlJSONObj = XML.toJSONObject(xml);
			JSONObject xmlJSONObj = JSONObject.fromObject(xml);
			JSONObject root = xmlJSONObj;
			if (root.has("DATA")) {
				Object data_null = root.get("DATA");
				if (data_null instanceof JSONObject) {
					JSONObject data = (JSONObject) data_null;
					getParam2(data);
					if (data.has("DATA_1")) {
						Object temp = data.get("DATA_1");
						if (temp instanceof JSONObject) {
							List aa = new ArrayList();
							aa.add(temp);
							root.put("DATA", aa);
						} else if (temp instanceof JSONArray) {
							root.put("DATA", temp);
						}
					}
				}
			}

			String jsonPrettyPrintString = root.toString();
			return jsonPrettyPrintString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
//		String xml ="<ROOT><RSPCOD>00505</RSPCOD><RSPMSG>验证签名失败，请核对信息！</RSPMSG><AUTH><SOURCE>5</SOURCE></AUTH></ROOT>";
//		xmltoJson_O(xml,"");
		String json ="{\"tran\":\"UUpdTaskInfo\",\"data\":{\"DEVICE_NO\":\"110\",\"APP_VERSION\":\"11\",\"FILE_SIZE\":\"100\",\"TASK_RESULTS\":[{\"TASK_ID\":\"111\",\"RET_RESULT\":\"Y\",\"RET_CODE\":\"100\",\"RET_MSG\":\"1231\"},{\"TASK_ID\":\"123\",\"RET_RESULT\":\"Y\",\"RET_CODE\":\"100\",\"RET_MSG\":\"1231\"}]},\"auth\":{\"REQUEST_TIME\":\"2018-01-19 17:59:32\",\"VERSION\":\"1101\",\"LANG\":\"en\",\"SOURCE\":\"5\"}}";
		jsonArrayToXML(json);
		//		String tesstr = "aaa=bbb&ccc=dd";
//		NettyHttpUtils net = new NettyHttpUtils(tesstr);
//		net.initData();
//		System.out.println(net.getParams("aaa"));

	}
}
