package cn.limit.vincent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    RateLimitClient rateLimitClient;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public @ResponseBody String index(String phone){
        boolean token = rateLimitClient.acquireToken(phone);
        return token + "";
    }

    @RequestMapping(value = "/qqq", method = RequestMethod.GET)
    public @ResponseBody String qqq(){
        return "qqq";
    }
}
