package org.springboot.mybatis.service.impl;
import org.springboot.mybatis.dao.CityDao;
import org.springboot.mybatis.dao.UserDefindDao;
import org.springboot.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private UserDefindDao userDefindDao;

    @Override
    public City findCityById(Integer id) {
        return cityDao.selectByPrimaryKey(id);
    }

    @Override
    public City findCityByName(String cityName) {
        //return cityDao.findByName(cityName);
        return userDefindDao.findByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return  cityDao.findAll();
    }

}
