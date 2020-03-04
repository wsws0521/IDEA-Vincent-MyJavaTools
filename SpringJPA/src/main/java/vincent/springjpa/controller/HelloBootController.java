package vincent.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vincent.springjpa.dao.TmpUserRepository;
import vincent.springjpa.pojo.TmpUser;

import java.util.List;

@RestController
public class HelloBootController {
    @Autowired
    TmpUserRepository tmpUserRepository;

    @RequestMapping("hello")
    public String helloBoot(){
        return "Hello Boot-JPA";
    }

    @RequestMapping("/toHello")
    public String toHello(ModelMap modelMap){
        tmpUserRepository.save(new TmpUser("Fucker",18));
        List<TmpUser> tmpUsers = tmpUserRepository.findAll();
        modelMap.put("users", tmpUsers);
        return "helloBoot";   //页面地址
    }
}
