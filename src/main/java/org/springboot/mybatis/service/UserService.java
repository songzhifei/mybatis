package org.springboot.mybatis.service;

import org.springboot.mybatis.domain.User;

import java.util.List;

public interface UserService {
    User findUserByName(String userName);

    List<User> findAll();
}
