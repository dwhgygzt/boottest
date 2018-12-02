package cn.guzt.boottest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Admin
 */
@RestController
public class IndexController {

    /**
     * 跳转首页，这里必须采用ModelAndView跳转，原因是类上注解为 @RestController
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    /**
     * 跳转首页，这里必须采用ModelAndView跳转，原因是类上注解为 @RestController
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView sysView(){ ;
        return index();
    }

}
