package com.business.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.db.mapper.SuperMapper;
import com.common.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @描述: 角色
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:35
 **/
public interface SysRoleMapper extends SuperMapper<SysRole> {

    List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

}
