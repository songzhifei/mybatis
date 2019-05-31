package org.springboot.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springboot.mybatis.domain.City;
import org.springboot.mybatis.mapper.CityMapper;

import java.util.List;

public interface CityDao extends CityMapper {
    /**
     * 根据城市名称，查询城市信息
             *
             * @param cityName 城市名
        */
    City findByName(@Param("cityName") String cityName);
    /**
     * 获取所有内容
     */
    List<City> findAll();
}

