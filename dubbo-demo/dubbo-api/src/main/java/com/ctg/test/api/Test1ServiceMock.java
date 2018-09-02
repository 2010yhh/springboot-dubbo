package com.ctg.test.api;

/**
 * @Description: mock只在出现非业务异常(比如超时，网络异常等)时执行(实际测试，服务不能停掉)，调用mock类
 * @Author: yanhonghai
 * @Date: 2018/8/31 1:23
 */
public class Test1ServiceMock implements Test1Service {
    @Override
    public String test1(String msg) {
        return "Test1Service服务降级：null";
    }
}
