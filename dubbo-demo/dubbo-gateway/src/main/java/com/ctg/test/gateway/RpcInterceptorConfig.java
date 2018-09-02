package com.ctg.test.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
 * @Description: 注册拦截器,类似于在xml中配置bean
 */    
@Configuration
public class RpcInterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
     public void addInterceptors(InterceptorRegistry registry){
         //指定拦截器类； //指定该类拦截的url
         registry.addInterceptor(new RpcInterceptor())
                 .addPathPatterns("/**");
     }
} 