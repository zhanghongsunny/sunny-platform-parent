package com.zuul.gateway.feign.fallback;

import cn.hutool.core.collection.CollectionUtil;
import com.zuul.gateway.feign.MenuService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @描述: menuService降级工场
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 16:33
 **/
@Slf4j
@Component
public class MenuServiceFallbackFactory implements FallbackFactory<MenuService> {

    @Override
    public MenuService create(Throwable throwable) {
        return roleIds -> {
            log.error("调用findByRoleCodes异常：{}", roleIds, throwable);
            return CollectionUtil.newArrayList();
        };
    }

}
