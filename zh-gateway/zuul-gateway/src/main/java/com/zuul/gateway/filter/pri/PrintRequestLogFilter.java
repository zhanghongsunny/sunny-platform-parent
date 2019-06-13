package com.zuul.gateway.filter.pri;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @描述:
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-13
 * @创建时间: 16:40
 **/
@Slf4j
@Component
public class PrintRequestLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;//要打印返回信息，必须得用"post
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {


        try {
            RequestContext context = RequestContext.getCurrentContext();
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            InputStream inputStream = request.getInputStream();
            String reqBbody = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
            String methodString = request.getMethod();
            String path = request.getRequestURI().toString();
            String remoteIp = request.getRemoteAddr();
            int remotePort = request.getRemotePort();
            String string = "客户端请求IP : " + remoteIp + ",端口 : " + remotePort + ", 请求接口名称: " + path + "  请求方法类型: " + methodString + "  请求参数: " + reqBbody;
            log.info(string);

            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            log.info("接口 " + request.getRequestURI().toString() + " 耗时: x ms，返回结果：" + body);
            context.setResponseBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
