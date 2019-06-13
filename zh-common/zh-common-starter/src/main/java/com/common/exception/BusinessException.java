package com.common.exception;

/**
 * @描述: 业务异常
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-12
 * @创建时间: 18:05
 **/
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }

}
