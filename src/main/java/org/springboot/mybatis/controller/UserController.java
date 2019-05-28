package org.springboot.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping(value = "/user")
@ApiIgnore
public class UserController {
    @RequestMapping(value = "/register")
    public String register(){
        return "User/Register";
    }
    @RequestMapping(value = "/index")
    public String index(){
        return "User/UsersList";
    }
    @RequestMapping(value = "/mul")
    public int mulParam(int param) {
        return 9/param;
    }
}
