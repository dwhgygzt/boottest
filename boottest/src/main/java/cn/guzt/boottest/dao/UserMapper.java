package cn.guzt.boottest.dao;

import cn.guzt.boottest.base.mapper.MyMapper;
import cn.guzt.boottest.domain.User;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.vo.CountCityUserVo;

import java.util.List;

/**
 * @author Admin
 */
public interface UserMapper extends MyMapper<User> {

    /**
     *  查询城市的人数
     * @param cityDto cityDto
     * @return 人数
     */
    List<CountCityUserVo> listCountCityUser(CityDto cityDto);

}