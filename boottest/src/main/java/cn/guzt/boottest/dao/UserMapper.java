package cn.guzt.boottest.dao;

import cn.guzt.boottest.base.mapper.MyMapper;
import cn.guzt.boottest.domain.User;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.vo.CountCityUserVo;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<CountCityUserVo> listCountCityUser(CityDto cityDto);

}