package com.search.admin.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @描述: 索引配置
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 17:12
 **/
@Setter
@Getter
@ConfigurationProperties(prefix = "zh.indices")
@RefreshScope
public class IndexProperties {

    /**
     * 配置过滤的索引名：默认只显示这些索引
     */
    private String[] show;

}
