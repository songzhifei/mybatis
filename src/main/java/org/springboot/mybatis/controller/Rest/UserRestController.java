package org.springboot.mybatis.controller.Rest;

import com.github.pagehelper.PageInfo;
import org.springboot.mybatis.common.CommonResult;
import org.springboot.mybatis.common.jqGridResult;
import org.springboot.mybatis.domain.MpUser;
import org.springboot.mybatis.dto.UserParams;
import org.springboot.mybatis.service.MpUserService;
import org.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private MpUserService mpUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult<User> verifyLogin(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password){

        User user = userService.findUserByName(userName);

        if(user != null && user.getPassword().equals(password)){
            return CommonResult.success(user,"登录成功！");
        }else{
            return CommonResult.failed("用户名或密码错误");
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult<UserParams> register(@RequestBody UserParams userParams){

        int res = 0;

        if(!userParams.getUserName().isEmpty() && !userParams.getPassword().isEmpty()){
            User user = new User(null,userParams.getUserName(),userParams.getEmail(),userParams.getPassword(),new Date(),false);
            res = userService.insertUser(user);
        }

        if(res==1){
            return CommonResult.success(userParams,"注册成功");
        }else{
            return CommonResult.failed("注册失败！");
        }

    }
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    public CommonResult<Boolean> verifyUser(@RequestParam(value = "userName",required = true) String userName){

        if(!userName.trim().isEmpty()){
            User user = userService.findUserByName(userName);

             if(user !=null){
                 return CommonResult.failed("该用户已存在!");
             }else{
                 return CommonResult.success(true);
             }
        }else{
            return CommonResult.failed("用户名不能为空!");
        }

    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public jqGridResult<MpUser> findUserByPage(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "rows",required = true) int rows){
        PageInfo<MpUser> pageInfo= mpUserService.GetList(page,rows);
        jqGridResult<MpUser> jqGridResult = org.springboot.mybatis.common.jqGridResult.success(pageInfo.getList(),pageInfo.getPages(),pageInfo.getTotal(),pageInfo.getPageNum(),"");
        //CommonResult<PageInfo<MpUser>> pageInfoCommonResult = CommonResult.success(pageInfo);
        return jqGridResult;
    }


}
