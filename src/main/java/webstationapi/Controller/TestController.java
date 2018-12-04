package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import webstationapi.Service.UserService;
import webstationapi.Service.TestService;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;


    @GetMapping(path = "/")
    public @ResponseBody
    void addTest() {
    }

}
