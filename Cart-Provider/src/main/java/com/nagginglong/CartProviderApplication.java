package com.nagginglong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:25
 */

@SpringBootApplication
@MapperScan(basePackages = "com.nagginglong.dao")
@EnableDiscoveryClient
public class CartProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(CartProviderApplication.class,args);

    }

}
