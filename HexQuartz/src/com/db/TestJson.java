package com.db;


import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String instanceName="fuck";
		
		String json = "{\"instanceName\":instanceName,\"1\":\"abc\"}";
		
		//JSONArray QuartzConfigJson = JSONArray.fromObject(json);
		Map<String, String> map = new HashMap<String, String>();
		map.put("instanceName", instanceName);
		map.put("1", "fuck");
		JSONArray QuartzConfigJson=new JSONArray();
		QuartzConfigJson.add(map);
		JSONObject jsonObject = JSONObject.fromObject(map);
		
		System.out.println(QuartzConfigJson);
	}

}
