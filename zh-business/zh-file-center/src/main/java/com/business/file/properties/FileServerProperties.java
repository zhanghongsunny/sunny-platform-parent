package com.business.file.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:57
 **/
@Data
@ConfigurationProperties(prefix = "zh.file-server")
@RefreshScope
public class FileServerProperties {

    /**
     * 为以下3个值，指定不同的自动化配置
     * qiniu：七牛oss
     * aliyun：阿里云oss
     * fastdfs：本地部署的fastDFS
     */
    private String type;

    /**
     * oss配置
     */
    OssProperties oss = new OssProperties();

    /**
     * fastDFS配置
     */
    FdfsProperties fdfs = new FdfsProperties();

}
