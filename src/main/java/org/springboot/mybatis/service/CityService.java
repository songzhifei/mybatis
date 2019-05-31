package org.springboot.mybatis.service;


import org.springboot.mybatis.domain.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    City findCityById(Integer id);
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    List<City> findAll();
}
