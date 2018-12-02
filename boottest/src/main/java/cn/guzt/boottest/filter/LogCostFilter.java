package cn.guzt.boottest.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Admin
 */
public class LogCostFilter implements Filter {

    // 默认logback日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("LogCostFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("{} Execute cost= {}",
                ((HttpServletRequest)servletRequest).getRequestURL().toString(),
                (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        logger.info("LogCostFilter destroy");
    }
}
