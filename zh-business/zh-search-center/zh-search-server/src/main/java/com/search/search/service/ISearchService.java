package com.search.search.service;

import com.alibaba.fastjson.JSONObject;
import com.common.entity.PageResult;
import com.serach.model.SearchDto;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 20:30
 **/
public interface ISearchService {

    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    PageResult<JSONObject> strQuery(String indexName, SearchDto searchDto);

}
