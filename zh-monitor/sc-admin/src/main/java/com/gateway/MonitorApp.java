package com.gateway;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
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
 * @创建时间: 23:53
 **/
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class MonitorApp {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApp.class, args);
    }


}
