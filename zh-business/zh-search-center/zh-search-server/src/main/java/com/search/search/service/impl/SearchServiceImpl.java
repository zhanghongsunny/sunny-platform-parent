package com.search.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.common.entity.PageResult;
import com.search.search.service.ISearchService;
import com.search.search.util.SearchBuilder;
import com.serach.model.SearchDto;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @描述: 通用搜索
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 20:44
 **/
@Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    @Override
    public PageResult<JSONObject> strQuery(String indexName, SearchDto searchDto) {
        return SearchBuilder.builder(elasticsearchTemplate, indexName)
                .setStringQuery(searchDto.getQueryStr())
                .addSort(searchDto.getSortCol(), SortOrder.DESC)
                .setIsHighlight(searchDto.getIsHighlighter())
                .getPage(searchDto.getPage(), searchDto.getLimit());
    }

}
