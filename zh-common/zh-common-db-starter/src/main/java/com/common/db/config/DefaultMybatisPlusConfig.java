package com.common.db.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * @描述: mybatis-plus配置
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-12
 * @创建时间: 17:13
 **/
@Import(DateMetaObjectHandler.class)
public class DefaultMybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 打印 sql，性能分析拦截器，不建议生产使用
     * 设置 dev test 环境开启
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
