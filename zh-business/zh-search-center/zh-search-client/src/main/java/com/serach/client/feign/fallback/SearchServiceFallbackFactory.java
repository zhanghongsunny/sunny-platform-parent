package com.serach.client.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.common.entity.PageResult;
import com.serach.client.feign.SearchService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @描述: searchService降级工场
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 20:40
 **/
@Slf4j
@Component
public class SearchServiceFallbackFactory  implements FallbackFactory<SearchService> {

    @Override
    public SearchService create(Throwable throwable) {
        return (indexName, searchDto) -> {
            log.error("通过索引{}搜索异常:{}", indexName, throwable);
            return PageResult.<JSONObject>builder().build();
        };
    }


}
