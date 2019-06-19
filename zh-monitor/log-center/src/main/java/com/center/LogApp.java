package com.center;

import com.serach.annotation.EnableSearchClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 23:38
 **/
@EnableDiscoveryClient
@EnableSearchClient
@SpringBootApplication
public class LogApp {

    public static void main(String[] args) {
        SpringApplication.run(LogApp.class, args);
    }


}
