package org.springboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springboot.mybatis.domain.City;

public interface UserDefindDao {
    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
