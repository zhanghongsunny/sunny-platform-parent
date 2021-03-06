package com.business.serach.client.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.business.serach.client.service.IQueryService;
import com.common.entity.PageResult;
import com.business.serach.client.feign.AggregationService;
import com.business.serach.client.feign.SearchService;
import com.business.serach.model.LogicDelDto;
import com.business.serach.model.SearchDto;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @描述: 搜索客户端Service
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 20:38
 **/
public class QueryServiceImpl implements IQueryService {

    @Resource
    private SearchService searchService;

    @Resource
    private AggregationService aggregationService;

    @Override
    public PageResult<JSONObject> strQuery(String indexName, SearchDto searchDto) {
        return strQuery(indexName, searchDto, null);
    }

    @Override
    public PageResult<JSONObject> strQuery(String indexName, SearchDto searchDto, LogicDelDto logicDelDto) {
        setLogicDelQueryStr(searchDto, logicDelDto);
        return searchService.strQuery(indexName, searchDto);
    }

    /**
     * 拼装逻辑删除的条件
     * @param searchDto 搜索dto
     * @param logicDelDto 逻辑删除dto
     */
    private void setLogicDelQueryStr(SearchDto searchDto, LogicDelDto logicDelDto) {
        if (logicDelDto != null
                && StrUtil.isNotEmpty(logicDelDto.getLogicDelField())
                && StrUtil.isNotEmpty(logicDelDto.getLogicNotDelValue())) {
            String result;
            //搜索条件
            String queryStr = searchDto.getQueryStr();
            //拼凑逻辑删除的条件
            String logicStr = logicDelDto.getLogicDelField() + ":" + logicDelDto.getLogicNotDelValue();
            if (StrUtil.isNotEmpty(queryStr)) {
                result = "(" + queryStr + ") AND " + logicStr;
            } else {
                result = logicStr;
            }
            searchDto.setQueryStr(result);
        }
    }

    /**
     * 访问统计聚合查询
     * @param indexName 索引名
     * @param routing es的路由
     */
    @Override
    public Map<String, Object> requestStatAgg(String indexName, String routing) {
        return aggregationService.requestStatAgg(indexName, routing);
    }

}
