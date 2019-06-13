package com.search.admin.model;

import lombok.Data;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 17:16
 **/
@Data
public class IndexVo {

    /**
     * 索引名
     */
    private String indexName;
    /**
     * 文档数
     */
    private Long docsCount;
    /**
     * 文档删除数
     */
    private Long docsDeleted;
    /**
     * 索引大小(kb)
     */
    private Double storeSizeInBytes;
    /**
     * 总查询数
     */
    private Long queryCount;
    /**
     * 总查询耗时(s)
     */
    private Double queryTimeInMillis;

}
