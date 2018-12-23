package cn.guzt.boottest.controller;

import cn.guzt.boottest.base.vo.PageVo;
import cn.guzt.boottest.base.vo.ResponseVo;
import cn.guzt.boottest.constants.Constants;
import cn.guzt.boottest.domain.City;
import cn.guzt.boottest.domain.User;
import cn.guzt.boottest.dto.CityDto;
import cn.guzt.boottest.dto.CityPageDto;
import cn.guzt.boottest.dto.LoginDto;
import cn.guzt.boottest.dto.UserDto;
import cn.guzt.boottest.service.SysService;
import cn.guzt.boottest.util.Md5Util;
import cn.guzt.boottest.vo.CountCityUserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
     * 创建用户
     * @param loginDto 登录参数封装
     * @return ResponseVo
     */
    @ApiOperation(value="用户登录验证", notes="用户名，密码登录验证")
    @ApiImplicitParam(name = "LoginDto", value = "登录参数封装", required = true, dataType = "LoginDto")
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ResponseVo loginCheck (@RequestBody @Validated LoginDto loginDto, HttpServletRequest request){
        User user = new User();
        user.setUserName(loginDto.getUserName());
        user.setPassword(Md5Util.encodeByMd5(loginDto.getPassword()));
        user = sysUserService.getSingleUser(user);
        if (user != null && user.getUserName() != null){
            request.getSession().setAttribute(Constants.SESSION_USER_KEY,user);
            return ResponseVo.success("登录验证成功");
        }else {
            return ResponseVo.fail("用户名或密码不正确");
        }
    }

    /**
     * 这里必须采用ModelAndView跳转，原因是类上注解为 @RestController
     * @return ModelAndView
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView sysView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
        modelAndView.getModelMap().addAttribute("userName",user.getUserName());
        modelAndView.getModelMap().addAttribute("mobile",user.getMobile());
        modelAndView.getModelMap().addAttribute("cityCode",user.getCityCode());
        modelAndView.setViewName("/main");
        return modelAndView;
    }

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

    /**
     * 按照id查询用户信息
     * @return ResponseVo
     */
    @ApiOperation(value="按照id查询用户信息", notes="restful类型的接口")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
    @GetMapping("/user/{id}")
    public ResponseVo<User> getSingleUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        return ResponseVo.success(sysUserService.getSingleUser(user));
    }

}
