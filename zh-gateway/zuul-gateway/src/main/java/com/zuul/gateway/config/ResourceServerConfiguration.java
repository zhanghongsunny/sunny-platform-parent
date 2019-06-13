package com.zuul.gateway.config;

import com.common.config.DefaultPasswordConfig;
import com.common.oauth2.config.DefaultResourceServerConf;
import com.common.oauth2.config.TokenStoreConfig;
import com.common.oauth2.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @描述: 资源服务器配置
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 14:31
 **/
@Configuration
@EnableResourceServer
@EnableConfigurationProperties(SecurityProperties.class)
@Import({DefaultPasswordConfig.class, TokenStoreConfig.class})
public class ResourceServerConfiguration extends DefaultResourceServerConf {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl = setHttp(http)
                .authorizeRequests()
                .antMatchers(securityProperties.getAuth().getHttpUrls()).authenticated()
                .antMatchers(securityProperties.getIgnore().getUrls()).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                //.antMatchers("/doc.html").permitAll()
                .anyRequest();
        setAuthenticate(authorizedUrl);
        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        http.headers()
                .frameOptions()
                .disable()
                .and()
                .csrf().disable();
    }

    @Override
    public HttpSecurity setAuthenticate(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl authorizedUrl) {
        return authorizedUrl.access("@permissionService.hasPermission(request, authentication)").and();
    }

}
