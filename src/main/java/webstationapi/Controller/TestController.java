package webstationapi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import webstationapi.Entity.Test;
import webstationapi.Service.AccountService;
import webstationapi.Service.TestService;

import java.util.List;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private AccountService accountService;


    @GetMapping(path = "/")
    public @ResponseBody
    void addTest() {
        accountService.getAll();
    }

}
