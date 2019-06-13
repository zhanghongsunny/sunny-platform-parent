package com.business.file.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.file.model.FileInfo;
import com.common.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @描述: 上传存储db
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 22:15
 **/
public interface FileMapper extends SuperMapper<FileInfo> {

    List<FileInfo> findList(Page<FileInfo> page, @Param("f") Map<String, Object> params);

}
