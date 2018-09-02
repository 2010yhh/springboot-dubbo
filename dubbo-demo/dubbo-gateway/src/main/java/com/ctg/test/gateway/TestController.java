package com.ctg.test.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ctg.test.api.Test1Service;
import com.ctg.test.api.Test2Service;
import com.ctg.test.api.Test3Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: yanhonghai
 * @Date: 2018/9/1 12:02
 */
@RestController
public class TestController {
    @Reference(version = "1.0.0")
    private Test1Service test1Service;
    @Reference(version = "1.0.0")
    private Test2Service test2Service;
    @Reference(version = "1.0.0")
    private Test3Service test3Service;
    @RequestMapping(value = "/test1")
    public Object test1(@RequestParam String name) {
        Map<String,Object> result=new HashMap<>();
        for(int i=0;i<6;i++){
            result.put("第"+i+"次请求结果：",test1Service.test1(name));
        }
        return result;
    }
    @RequestMapping(value = "/test2")
    public Object test2(@RequestParam String name) {

        Map<String,Object> result=new HashMap<>();
        for(int i=0;i<6;i++){
            result.put("第"+i+"次请求结果：",test2Service.test2(name));
        }
        return result;
    }
    @RequestMapping(value = "/test3")
    public Object test3(@RequestParam String name) {

        Map<String,Object> result=new HashMap<>();
        for(int i=0;i<6;i++){
            result.put("第"+i+"次请求结果：",test3Service.test3(name));
        }
        return result;
    }
    @RequestMapping(value = "/")
    public String hi2() {
        return "hello";
    }
}
