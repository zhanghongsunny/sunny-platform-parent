package com.common.oauth2.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @描述: 验证码配置
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 10:00
 **/
@Setter
@Getter
public class ValidateCodeProperties {

    /**
     * 设置认证通时不需要验证码的clientId
     */
    private String[] ignoreClientCode = {};

}
