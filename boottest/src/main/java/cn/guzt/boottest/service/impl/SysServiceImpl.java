package cn.guzt.boottest.service.impl;

import cn.guzt.boottest.base.exception.BusinessException;
import cn.guzt.boottest.base.vo.PageVo;
import cn.guzt.boottest.constants.Constants;
import cn.guzt.boottest.dao.CityMapper;
import cn.guzt.boottest.dao.UserMapper;
import cn.guzt.boottest.domain.City;
import cn.guzt.boottest.domain.User;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.CityPageDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.service.SysService;
import cn.guzt.boottest.util.MD5Util;
import cn.guzt.boottest.vo.CountCityUserVo;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * SysUserServiceImpl
 * @author Admin
 */

@Service
public class SysServiceImpl implements SysService {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveCity(CityDto cityDto) {
        Example example =new Example(City.class);
        example.createCriteria().andEqualTo("code",cityDto.getCode());
        if (cityMapper.selectCountByExample(example) > 0){
            BusinessException.create("该城市编码已结存在");
        }

        City city = JSONObject.parseObject(JSONObject.toJSONString(cityDto),City.class);
        city.setId(null);
        city.setCreateTime(new Date());
        city.setCreateOperId(Constants.DEFAULT_CREATE_OPER);
        cityMapper.insertSelective(city);
    }

    @Override
    public void saveUser(UserDto userDto) {
        Example example =new Example(City.class);
        example.createCriteria().andEqualTo("code",userDto.getCityCode());
        City city = cityMapper.selectOneByExample(example);
        if (city == null){
            BusinessException.create("该城市编码不存在");
        }

        example =new Example(User.class);
        example.createCriteria().andEqualTo("mobile",userDto.getMobile());
        if (userMapper.selectCountByExample(example) > 0){
            BusinessException.create("该手机号已存在");
        }

        User user = JSONObject.parseObject(JSONObject.toJSONString(userDto),User.class);
        user.setCityName(city.getName());
        user.setId(null);
        user.setPassword(MD5Util.encodeByMd5(user.getPassword()));
        user.setCreateTime(new Date());
        user.setCreateOperId(Constants.DEFAULT_CREATE_OPER);
        userMapper.insertSelective(user);
    }

    @Override
    public PageVo<City> listCity(CityPageDto cityPageDto) {
        Example example = new Example(City.class);
        Example.Criteria criteria = example.createCriteria();
        if (! StringUtils.isEmpty(cityPageDto.getCode())){
            criteria.andEqualTo("code",cityPageDto.getCode());
        }
        if (! StringUtils.isEmpty(cityPageDto.getName())){
            criteria.andEqualTo("name",cityPageDto.getName());
        }
        if (!StringUtils.isEmpty(cityPageDto.getSearchStartTime())){
            criteria.andGreaterThan("createTime",cityPageDto.getSearchStartTime());
        }
        if (!StringUtils.isEmpty(cityPageDto.getSearchEndTime())){
            criteria.andLessThan("createTime",cityPageDto.getSearchEndTime());
        }
        example.orderBy("id").desc();

        PageInfo<City> pageInfo = PageHelper.startPage(
                cityPageDto.getPageNum(),cityPageDto.getPageSize(),
                true).doSelectPageInfo(() -> cityMapper.selectByExample(example));
        return new PageVo<>(pageInfo);
    }

    @Override
    public List<CountCityUserVo> listCountCityUser(CityDto cityDto) {
        return userMapper.listCountCityUser(cityDto);
    }
}
