package com.serach.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @描述: 逻辑删除条件对象
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 20:34
 **/
@Data
@AllArgsConstructor
public class LogicDelDto {

    /**
     * 逻辑删除字段名
     */
    private String logicDelField;

    /**
     * 逻辑删除字段未删除的值
     */
    private String logicNotDelValue;

}
