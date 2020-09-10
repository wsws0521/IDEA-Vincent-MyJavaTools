package cn.vincent.xmlvend.hexwsxmlvend.controller;

import cn.vincent.xmlvend.hexwsxmlvend.model.ReturnT;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("username","vincent");
        return "index";
    }
    @RequestMapping(value="login", method= RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> loginDo(HttpServletRequest request, HttpServletResponse response, String AgentNo, String PassWord){
        ReturnT<String> result = new ReturnT<>();
        result.setCode(200);
        result.setContent(AgentNo + PassWord);
        return result;
    }
}
