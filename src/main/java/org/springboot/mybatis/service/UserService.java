package org.springboot.mybatis.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    User findUserByName(String userName);

    List<User> findAll();

    int insertUser(User user);

    PageInfo findUserByPage(int pageNum,int pageSize);
}
