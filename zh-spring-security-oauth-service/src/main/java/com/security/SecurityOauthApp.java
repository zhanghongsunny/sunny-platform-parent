package com.security;

import com.common.annotation.EnableLoginArgResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @描述: 认证服务
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 11:27
 **/
@EnableFeignClients
@EnableDiscoveryClient
@EnableRedisHttpSession
@EnableLoginArgResolver
@ComponentScan(basePackages = "com.common.feign.fallback")
@SpringBootApplication
public class SecurityOauthApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauthApp.class, args);
    }

}
