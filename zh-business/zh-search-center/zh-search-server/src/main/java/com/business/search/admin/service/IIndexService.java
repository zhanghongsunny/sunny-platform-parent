package com.business.search.admin.service;

import com.business.search.admin.model.IndexDto;
import com.business.search.admin.model.IndexVo;
import com.common.entity.PageResult;

import java.util.Map;

/**
 * @描述: 索引
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 17:18
 **/
public interface IIndexService {

    /**
     * 创建索引
     */
    void create(IndexDto indexDto);

    /**
     * 删除索引
     * @param indexName 索引名
     */
    void delete(String indexName);

    /**
     * 索引列表
     * @param queryStr 搜索字符串
     * @param indices 默认显示的索引名
     */
    PageResult<IndexVo> list(String queryStr, String... indices);

    /**
     * 显示索引明细
     * @param indexName 索引名
     */
    Map<String, Object> show(String indexName);

}
