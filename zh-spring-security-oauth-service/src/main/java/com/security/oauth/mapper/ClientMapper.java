package com.security.oauth.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.db.mapper.SuperMapper;
import com.security.oauth.model.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 13:49
 **/
public interface ClientMapper extends SuperMapper<Client> {

    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params);

}
