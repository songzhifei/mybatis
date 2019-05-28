package org.springboot.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springboot.mybatis.dao.MpUserDao;
import org.springboot.mybatis.domain.MpUser;
import org.springboot.mybatis.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MpUserServiceImpl implements MpUserService {
    @Autowired
    private MpUserDao mpUserDao;
    @Override
    public PageInfo GetList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MpUser> list = mpUserDao.findAll();
        PageInfo<MpUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
