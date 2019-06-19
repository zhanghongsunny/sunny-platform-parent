package com.business.search;

import com.business.search.admin.properties.IndexProperties;
import com.common.annotation.EnableLoginArgResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 17:04
 **/
@EnableLoginArgResolver
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(IndexProperties.class)
public class SearchCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchCenterApp.class, args);
    }

}
