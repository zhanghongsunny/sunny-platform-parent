package com.common.oauth2.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @描述: 认证服务器使用Redis存取令牌  【需要配置redis参数】
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 09:52
 **/
public class AuthRedisTokenStore {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate ;

    @Bean
    public TokenStore tokenStore() {
        RedisTemplateTokenStore redisTemplateStore = new RedisTemplateTokenStore()  ;
        redisTemplateStore.setRedisTemplate(redisTemplate);
        return redisTemplateStore;
    }

}
