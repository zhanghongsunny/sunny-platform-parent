package com.business;

import com.common.annotation.EnableLoginArgResolver;
import com.business.serach.annotation.EnableSearchClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @描述: 用户中心
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:13
 **/
@EnableLoginArgResolver
@EnableDiscoveryClient
@EnableSearchClient
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.common.lock", "com.business.serach.client.feign"})
@SpringBootApplication
public class UserCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApp.class, args);
    }

}
