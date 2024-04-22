package cn.vincent.fastjson;

import com.alibaba.fastjson.JSONObject;
import cn.vincent.fastjson.pojo.Mt;

import java.util.List;

public class TestJson {
    public static final String jsonStr = "[{\"meters\":\"123,456,\",\"tokens\":\"11111,22222,33333,44444,\"}]";
    public static void main(String[] args) {
        List<Mt> details = JSONObject.parseArray(jsonStr, Mt.class);
        System.out.println(details);
    }
}
