package com.business.user.cofig;

import com.common.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:17
 **/
@Configuration
@MapperScan({"com.business.user.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {
}
