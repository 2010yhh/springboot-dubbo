package com.ctg.test.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *访问：http://localhost:8092/test3?name=zyq
 */
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run= SpringApplication.run(ConsumerApplication.class, args);
    }
}
