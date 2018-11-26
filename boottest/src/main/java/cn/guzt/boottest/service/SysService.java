package cn.guzt.boottest.service;

import cn.guzt.boottest.base.vo.PageVo;
import cn.guzt.boottest.domain.City;
import cn.guzt.boottest.domain.User;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.CityPageDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.vo.CountCityUserVo;

import java.util.List;

/**
 * SysService
 * @author Admin
 */
public interface SysService {


    void saveCity(CityDto cityDto);

    void saveUser(UserDto userDto);

    PageVo<City> listCity(CityPageDto cityPageDto);

    List<CountCityUserVo> listCountCityUser(CityDto cityDto);

    User getSingleUser(User user);

}
