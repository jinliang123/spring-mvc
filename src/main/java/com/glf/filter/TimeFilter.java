package com.glf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * description
 *
 * @author jinliang 2019/05/08 13:51
 */
//@Component
public class TimeFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = new Date().getTime();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("request uri:"+request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
        long end = new Date().getTime();
        logger.info("used time:"+(end-start));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("time filter init ...");
    }

    @Override
    public void destroy() {
        logger.info("time filter destroy ...");
    }
}
