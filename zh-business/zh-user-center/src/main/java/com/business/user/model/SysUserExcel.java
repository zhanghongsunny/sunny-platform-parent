package com.business.user.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.common.constant.CommonConstant;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @描述: 用户导出实例
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 21:15
 **/
@Data
@ToString
public class SysUserExcel implements Serializable {

    private static final long serialVersionUID = -5886012896705137070L;

    @Excel(name = "用户姓名", height = 20, width = 30, isImportField = "true_st")
    private String username;

    @Excel(name = "用户昵称", height = 20, width = 30, isImportField = "true_st")
    private String nickname;

    @Excel(name = "手机号码", height = 20, width = 30, isImportField = "true_st")
    private String mobile;

    @Excel(name = "学生性别", replace = { "男_0", "女_1" }, suffix = "生", isImportField = "true_st")
    private Integer sex;

    @Excel(name = "创建时间", format = CommonConstant.DATETIME_FORMAT, isImportField = "true_st", width = 20)
    private Date createTime;

    @Excel(name = "修改时间", format = CommonConstant.DATETIME_FORMAT, isImportField = "true_st", width = 20)
    private Date updateTime;

}
