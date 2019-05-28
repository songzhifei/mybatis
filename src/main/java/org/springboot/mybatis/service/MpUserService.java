package org.springboot.mybatis.service;

import com.github.pagehelper.PageInfo;
import org.springboot.mybatis.domain.MpUser;

import java.util.List;

public interface MpUserService {
    PageInfo GetList(int pageNum, int pageSize);
}
