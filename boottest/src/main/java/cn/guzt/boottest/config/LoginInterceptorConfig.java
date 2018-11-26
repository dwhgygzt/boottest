package cn.guzt.boottest.config;

import cn.guzt.boottest.Interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class LoginInterceptorConfig implements WebMvcConfigurer {

    /**
     * interceptor配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/sys/**")
                //排除不需要验证登录用户操作权限的请求
                //.excludePathPatterns("/")
                .excludePathPatterns("/index")
                .excludePathPatterns("/sys/loginCheck")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/static/**");
    }
}