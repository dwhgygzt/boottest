package cn.guzt.boottest.Interceptor;

import cn.guzt.boottest.constants.Constants;
import cn.guzt.boottest.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用于登录判断的拦截器.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private List<String> exceptURIs;

    /**
     * <p>Title: afterCompletion.</P>
     * <p>Description:
     * 	该方法需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
     * 	该方法将在整个请求完成之后，这个方法的主要作用是用于清理资源的，
     *
     * </P>
     * @param arg0 HttpServletRequest
     * @param arg1 HttpServletResponse
     * @param arg2 Object
     * @param arg3 Exception
     * @throws Exception Exception
     * @see HandlerInterceptor#afterCompletion
     * 		(javax.servlet.http.HttpServletRequest,
     * 		 javax.servlet.http.HttpServletResponse,
     * 		 java.lang.Object, java.lang.Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    /**
     * <p>Title: postHandle.</P>
     * <p>Description:
     * 	这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行
     * 	postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后，也就是在Controller的方法调用之后执行
     * 	但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操 作。
     * </P>
     * @param arg0 HttpServletRequest
     * @param arg1 HttpServletResponse
     * @param arg2 arg2
     * @param arg3 ModelAndView
     * @throws Exception Exception
     * @see HandlerInterceptor#postHandle
     * 		(javax.servlet.http.HttpServletRequest,
     * 		 javax.servlet.http.HttpServletResponse,
     * 	     java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    /**
     * <p>Title: preHandle.</P>
     * <p>Description:
     * 	preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * 	SpringMVC中的Interceptor拦截器是链式的，可以同时存在 多个Interceptor，
     * 	然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * 	Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返回值为false，
     * 	当preHandle的返回值为false的时候整个请求就结束了。
     * </P>
     * @return true 验证通过 false 验证不通过
     * @throws Exception Exception
     * @see HandlerInterceptor#preHandle
     * 		(javax.servlet.http.HttpServletRequest,
     *       javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String requestURI = request.getRequestURI(); // 访问URL
        logger.info("requestURI:" + requestURI);
        // exceptURIs不需要拦截验证
        if (exceptURIs != null && !exceptURIs.isEmpty()) {
            for (String url : exceptURIs) {
                if (requestURI.contains(url)) {
                    return true;
                }
            }
        }
        if (checkLogin(request, requestURI)) // 已经登录
        {
            return true;
        }else // 未登录或登录超时
        {
            logger.info("未登录或登录超时: "+requestURI);
            /*
             *   是否为ajax请求
             *   是：直接返回JSON格式的错误提示信息
             *   否：跳转至登录界面
             */
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(401);
                response.setHeader("sessionstatus", "timeout");
                JSONObject model = new JSONObject();
                model.put("code", 401);
                model.put("message", "未登录或登录超时");
                model.put("data", "{}");
                response.getWriter().print(model.toJSONString());
            }else{
                response.sendRedirect(request.getContextPath() + "/index");
            }
            return false;
        }
    }

    /**
     * 验证用户是否已经登录.
     * @param request HttpServletRequest
     * @param requestURI requestURI
     * @return true 验证通过 false 验证不通过
     */
    private boolean checkLogin(HttpServletRequest request, String requestURI)
    {
        logger.info("request.getSession()="+request.getSession().getId());
        logger.info("开始拦截器验证: "+requestURI);
        Object obj = request.getSession().getAttribute(Constants.SESSION_USER_KEY);
        if (obj == null){
            return false;
        }
        if (obj instanceof User){
            User user = (User)obj;
            logger.info("用户["+user.getUserName()+"]通过验证");
            return true;
        }else{
            logger.info("拦截器验证失败: "+requestURI);
            return false;
        }
    }

    /**
     * @param exceptURIs the exceptURIs to set
     */
    public void setExceptURIs(List<String> exceptURIs) {
        this.exceptURIs = exceptURIs;
    }

}