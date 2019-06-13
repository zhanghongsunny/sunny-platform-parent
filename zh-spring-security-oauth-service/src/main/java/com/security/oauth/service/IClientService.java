package com.security.oauth.service;

import com.common.entity.PageResult;
import com.common.entity.Result;
import com.common.service.ISuperService;
import com.security.oauth.model.Client;

import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 13:44
 **/
public interface IClientService extends ISuperService<Client> {

    Result saveClient(Client clientDto);

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClent(Map<String, Object> params, boolean isPage);

    void delClient(long id);

}
