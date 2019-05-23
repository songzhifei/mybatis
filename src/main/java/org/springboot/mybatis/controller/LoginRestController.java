package org.springboot.mybatis.controller;

import org.springboot.mybatis.common.CommonResult;
import org.springboot.mybatis.domain.User;
import org.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class LoginRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult<User> verifyLogin(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password){

        User user = userService.findUserByName(userName);

        if(user != null && user.getPassword().equals(password)){
            return CommonResult.success(user,"登录成功！");
        }else{
            return CommonResult.failed("用户名或密码错误");
        }
    }
}
