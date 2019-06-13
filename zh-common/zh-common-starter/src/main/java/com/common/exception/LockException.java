package com.common.exception;

/**
 * @描述: 分布式锁异常
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-12
 * @创建时间: 18:06
 **/
public class LockException extends RuntimeException{

    private static final long serialVersionUID = 6610083281801529147L;

    public LockException(String message) {
        super(message);
    }

}
