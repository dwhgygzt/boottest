package cn.guzt.boottest.controller;

import cn.guzt.boottest.base.vo.PageVo;
import cn.guzt.boottest.base.vo.ResponseVo;
import cn.guzt.boottest.domain.City;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.CityPageDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.service.SysService;
import cn.guzt.boottest.vo.CountCityUserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * SysController Test
 * @author Admin
 */
@RestController
@RequestMapping("/sys")
public class SysController {


    @Resource
    private SysService sysUserService;


    /**
     * 创建城市
     * @param cityDto 前端传递的city相关参数
     * @return ResponseVo
     */
    @ApiOperation(value="创建城市", notes="创建用户所在城市，code字段唯一")
    @ApiImplicitParam(name = "cityDto", value = "详细实体city", required = true, dataType = "CityDto")
    @RequestMapping(value = "/add/city", method = RequestMethod.POST)
    public ResponseVo addCity (@RequestBody @Validated CityDto cityDto){
        sysUserService.saveCity(cityDto);
        return ResponseVo.success("创建成功");
    }

    /**
     * 创建用户
     * @param userDto 前端传递的user相关参数
     * @return ResponseVo
     */
    @ApiOperation(value="创建用户", notes="创建用户，mobile字段唯一")
    @ApiImplicitParam(name = "userDto", value = "详细实体user", required = true, dataType = "UserDto")
    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public ResponseVo addUser (@RequestBody @Validated UserDto userDto){
        sysUserService.saveUser(userDto);
        return ResponseVo.success("创建成功");
    }

    /**
     * 分页查询城市
     * @param cityPageDto 前端传递的查询相关参数
     * @return ResponseVo
     */
    @ApiOperation(value="分页查询城市", notes="分页查询城市，通过pagehelper插件进行物理分页")
    @ApiImplicitParam(name = "cityPageDto", value = "分页查询实体", required = true, dataType = "CityPageDto")
    @RequestMapping(value = "/list/city", method = RequestMethod.POST)
    public ResponseVo<PageVo<City>> listCity (@RequestBody CityPageDto cityPageDto){
        return ResponseVo.success(sysUserService.listCity(cityPageDto));
    }

    /**
     * 汇总查询城市人数
     * @return ResponseVo
     */
    @ApiOperation(value="汇总查询城市人数", notes="汇总查询城市人数")
    @ApiImplicitParam(name = "cityDto", value = "详细实体city", required = true, dataType = "CityDto")
    @RequestMapping(value = "/count/cityuser", method = RequestMethod.POST)
    public ResponseVo<List<CountCityUserVo>> listCountCityUser (@RequestBody CityDto cityDto){
        return ResponseVo.success(sysUserService.listCountCityUser(cityDto));
    }


}
