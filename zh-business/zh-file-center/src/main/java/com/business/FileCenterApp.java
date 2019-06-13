package com.business;

import com.business.file.properties.FileServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @描述: 文件中心
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:56
 **/
@EnableDiscoveryClient
@EnableConfigurationProperties(FileServerProperties.class)
@SpringBootApplication
public class FileCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(FileCenterApp.class, args);
    }

}
