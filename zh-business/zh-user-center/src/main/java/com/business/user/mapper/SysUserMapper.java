package com.business.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.db.mapper.SuperMapper;
import com.common.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @描述: 用户表 Mapper 接口
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:22
 **/
public interface SysUserMapper extends SuperMapper<SysUser> {

    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysUser> findList(Page<SysUser> page, @Param("u") Map<String, Object> params);

}
