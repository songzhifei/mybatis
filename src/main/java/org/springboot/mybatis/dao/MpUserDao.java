package org.springboot.mybatis.dao;

import org.springboot.mybatis.domain.MpUser;
import org.springboot.mybatis.mapper.MpUserMapper;

import java.util.List;

public interface MpUserDao extends MpUserMapper {
    /**
     * 获取所有内容
     */
    List<MpUser> findAll();
}
