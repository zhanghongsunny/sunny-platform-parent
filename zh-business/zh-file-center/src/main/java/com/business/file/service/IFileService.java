package com.business.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.business.file.model.FileInfo;
import com.common.entity.PageResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @描述: 文件service
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 22:13
 **/
public interface IFileService extends IService<FileInfo> {

    FileInfo upload(MultipartFile file ) throws Exception;

    PageResult<FileInfo> findList(Map<String, Object> params);

    void delete(String id);

}
