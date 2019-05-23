package org.springboot.mybatis.service.impl;

import org.springboot.mybatis.dao.UserDao;
import org.springboot.mybatis.domain.User;
import org.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
