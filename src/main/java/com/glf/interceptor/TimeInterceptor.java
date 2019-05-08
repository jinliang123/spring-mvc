package com.glf.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * description
 *
 * @author jinliang 2019/05/08 14:17
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("prehandler ...");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String className = handlerMethod.getBean().getClass().getName();
        logger.info("className:"+className);
        String methodName = handlerMethod.getMethod().getName();
        logger.info("methodName:" +methodName);
        //记录请求开始时间
        request.setAttribute("startTime",new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("posthandler...");
        long startTime = (long) request.getAttribute("startTime");
        logger.info("used time:"+(new Date().getTime()-startTime));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("after completion");
        long startTime = (long) request.getAttribute("startTime");
        logger.info("time interceptor used time:"+(new Date().getTime()-startTime));
        //如果抛出异常 打印异常信息
        logger.info("exception is " +ex);
    }
}
