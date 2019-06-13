package com.business.user.service;

import com.common.entity.PageResult;
import com.common.entity.Result;
import com.common.entity.SysRole;
import com.common.service.ISuperService;

import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:24
 **/
public interface ISysRoleService extends ISuperService<SysRole> {

    void saveRole(SysRole sysRole);

    void deleteRole(Long id);

    /**
     * 角色列表
     * @param params
     * @return
     */
    PageResult<SysRole> findRoles(Map<String, Object> params);

    /**
     * 新增或更新角色
     * @param sysRole
     * @return Result
     */
    Result saveOrUpdateRole(SysRole sysRole);

}
