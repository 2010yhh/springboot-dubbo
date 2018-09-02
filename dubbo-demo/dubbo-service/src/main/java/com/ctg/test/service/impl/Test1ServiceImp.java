package com.ctg.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ctg.test.api.Test1Service;
import com.ctg.test.service.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @Description: 启动2个实例，一个接口延时，一个接口正常。
 * @Author: yanhonghai
 * @Date: 2018/8/30 0:32
 */

@Service(version = "1.0.0",mock = "com.ctg.test.api.Test1ServiceMock")
public class Test1ServiceImp implements Test1Service {
    @Autowired
    private Environment env;
    @Autowired
    IpUtil ipUtil;
    public String test1(String msg) {
        //加入延时，模拟调用超时
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ip="";
        try {
            InetAddress inetAddress=ipUtil.getLocalHostLANAddress();
            ip=inetAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "From "+ip+":"+env.getProperty("server.port")+",Test1Service response:"+msg;
    }

}
