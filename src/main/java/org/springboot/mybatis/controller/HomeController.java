package org.springboot.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping(value = "/Home")
@ApiIgnore
public class HomeController {
    @RequestMapping(value = "/Index")
    public String Index(){
        //return "Home/Index";
        return "Home/HomePage";
    }
}
