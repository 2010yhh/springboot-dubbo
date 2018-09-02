package com.ctg.test.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author: yanhonghai
 * @Date: 2018/9/1 12:05
 */
@Component
public class RpcInterceptor implements HandlerInterceptor{
    private Logger log = LoggerFactory.getLogger(RpcInterceptor.class);
    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("RpcInterceptor preHandle被调用");
        //只有返回true才会继续向下执行，返回false取消当前请求
        String token=httpServletRequest.getParameter("token");
        if(token!=null&&token.equals("123456")){
            return true;
        }
        httpServletResponse.getWriter().write("token error");
        return false;
    }
    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("RpcInterceptor postHandle被调用");
    }
    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("RpcInterceptor afterCompletion被调用");
    }
}
