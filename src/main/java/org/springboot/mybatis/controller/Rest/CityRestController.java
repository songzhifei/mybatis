package org.springboot.mybatis.controller.Rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springboot.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/api/city")
@Api("CityController相关接口")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取单个城市信息")
    @RequestMapping(value = "/api/getCity", method = RequestMethod.GET)
    public City findAll(@RequestParam(value = "id", required = true) Integer id) {
        return cityService.findCityById(id);
    }
    @ApiOperation(value = "获取单个城市信息")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }
    @ApiOperation(value = "获取所有城市信息")
    @RequestMapping(value = "/api/all", method = RequestMethod.GET)
    public List<City> findAll() {
        return cityService.findAll();
    }

}
