package com.zuul.gateway.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 15:51
 **/
@Slf4j
public abstract class WebLogAspectAdapter {

    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String methodString = request.getMethod();
        String path = request.getRequestURI().toString();
        String remoteIp = request.getRemoteAddr();
        int remotePort = request.getRemotePort();

        String value = "application/json";
        String key = request.getHeader("content-type");
        Object[] args = joinPoint.getArgs();
        String paramterString = "";

        Enumeration<String> enu = request.getParameterNames();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            hashMap.put(name, request.getParameter(name));
        }
        request.setAttribute("starttime", System.currentTimeMillis());
        if (hashMap.size() == 0 && "post".equalsIgnoreCase(methodString) && key.contains(value)) {
            paramterString = JSON.toJSONString(args);
        } else {
            paramterString = JSON.toJSONString(hashMap);
        }
        String string = "客户端请求IP : " + remoteIp + ",端口 : " + remotePort + ", 请求接口名称: " + path + "  请求方法类型: " + methodString + "  请求参数: " + paramterString;
        log.info(string);
    }

    public void doAfterReturning(Object ret) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 处理完请求，返回内容
        //log.info("RESPONSE : " + ret);

        log.info("接口 " + request.getRequestURI().toString() + " 耗时:" + (System.currentTimeMillis() - Long.parseLong(request.getAttribute("starttime").toString())) + " ms，返回结果："
                + (JSON.toJSONStringWithDateFormat(ret, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat)));
    }

}
