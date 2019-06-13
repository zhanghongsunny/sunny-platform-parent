package com.common.oauth2.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.common.constant.CommonConstant;
import com.common.entity.SysMenu;
import com.common.oauth2.properties.SecurityProperties;
import com.common.oauth2.service.IPermissionService;
import com.common.oauth2.util.AuthUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @描述: 请求权限判断service
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 10:03
 **/
@Slf4j
public abstract class DefaultPermissionServiceImpl implements IPermissionService {

    @Autowired
    private SecurityProperties securityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 查询当前用户拥有的资源权限
     * @param roleCodes 角色code列表，多个以','隔开
     * @return
     */
    public abstract List<SysMenu> findMenuByRoleCodes(String roleCodes);

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 前端跨域OPTIONS请求预检放行 也可通过前端配置代理实现
        // 在这里放行具有一定风险,也可通过前端配置代理实现
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            //判断是否开启url权限验证
            if (!securityProperties.getAuth().isUrlEnabled()) {
                return true;
            }
            //超级管理员admin不需认证
            String username = AuthUtils.getUsername(authentication);
            if (CommonConstant.ADMIN_USER_NAME.equals(username)) {
                return true;
            }

            //判断认证通过后，所有用户都能访问的url
            for (String path : securityProperties.getIgnore().getMenusPaths()) {
                if (antPathMatcher.match(path, request.getRequestURI())) {
                    return true;
                }
            }

            List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
            if (CollectionUtil.isEmpty(grantedAuthorityList)) {
                log.warn("角色列表为空：{}", authentication.getPrincipal());
                return false;
            }

            String roleCodes = grantedAuthorityList.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.joining(", "));
            List<SysMenu> menuList = findMenuByRoleCodes(roleCodes);
            for (SysMenu menu : menuList) {
                if (StringUtils.isNotEmpty(menu.getPath()) && StringUtils.isNotEmpty(menu.getPathMethod())
                        && antPathMatcher.match(menu.getPath(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(menu.getPathMethod())) {
                    return true;
                }
            }
        }

        return false;
    }

}
