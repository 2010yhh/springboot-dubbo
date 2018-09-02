package com.ctg.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ctg.test.api.Test3Service;
import com.ctg.test.service.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @Description: TODO
 * @Author: yanhonghai
 * @Date: 2018/8/30 0:32
 */
@Service(version = "1.0.0")
public class Test3ServiceImp implements Test3Service {
    @Autowired
    IpUtil ipUtil;
    @Autowired
    private Environment env;
    public String test3(String msg) {
        //可在一个启动实例中加入延时，模拟调用超时
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String ip="";
        try {
            InetAddress inetAddress=ipUtil.getLocalHostLANAddress();
            ip=inetAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "From "+ip+":"+env.getProperty("server.port")+"Test3Service response:"+msg;
    }
}
