package com.business.user.service;

import com.business.user.model.SysUserExcel;
import com.common.entity.LoginAppUser;
import com.common.entity.PageResult;
import com.common.entity.Result;
import com.common.entity.SysRole;
import com.common.entity.SysUser;
import com.common.service.ISuperService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:21
 **/
public interface ISysUserService extends ISuperService<SysUser> {

    /**
     * 获取UserDetails对象
     * @param username
     * @return
     */
    LoginAppUser findByUsername(String username);

    LoginAppUser findByOpenId(String username);

    LoginAppUser findByMobile(String username);

    /**
     * 通过SysUser 转换为 LoginAppUser，把roles和permissions也查询出来
     * @param sysUser
     * @return
     */
    LoginAppUser getLoginAppUser(SysUser sysUser);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);
    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    SysUser selectByMobile(String mobile);
    /**
     * 根据openId查询用户
     * @param openId
     * @return
     */
    SysUser selectByOpenId(String openId);

    /**
     * 用户分配角色
     * @param id
     * @param roleIds
     */
    void setRoleToUser(Long id, Set<Long> roleIds);

    /**
     * 更新密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Result updatePassword(Long id, String oldPassword, String newPassword);

    /**
     * 用户列表
     * @param params
     * @return
     */
    PageResult<SysUser> findUsers(Map<String, Object> params);


    /**
     * 用户角色列表
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(Long userId);

    /**
     * 状态变更
     * @param params
     * @return
     */
    Result updateEnabled(Map<String, Object> params);

    /**
     * 查询全部用户
     * @param params
     * @return
     */
    List<SysUserExcel> findAllUsers(Map<String, Object> params);

    Result saveOrUpdateUser(SysUser sysUser);

    /**
     * 删除用户
     */
    boolean delUser(Long id);

    /**
     * 保存用户
     *
     * @param users
     */
    void saveUsers(List<SysUser> users);

}
