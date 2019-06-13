package org.springframework.cloud.netflix.ribbon;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.ribbon.SpringClientFactory.NAMESPACE;

/**
 * @描述: 扩展 spring cloud ribbon的PropertiesFactory
 * 使其能够支持 配置全局的ribbon.NFLoadBalancerRuleClassName=package.YourRule
 * 然后各个微服务还可以根据自身情况做个性化定制。
 * 如:SERVICE_ID.ribbon.NFLoadBalancerRuleClassName=package.YourRule
 * @版权: Copyright (c) 2019
 * @公司:
 * @author: zhanghong
 * @版本: 1.0
 * @创建日期: 2019-06-12
 * @创建时间: 19:59
 **/
public class DefaultPropertiesFactory extends PropertiesFactory {

    @Autowired
    private Environment environment;

    private Map<Class, String> classToProperty = new HashMap<>(5);

    public DefaultPropertiesFactory() {
        super();
        classToProperty.put(ILoadBalancer.class, "NFLoadBalancerClassName");
        classToProperty.put(IPing.class, "NFLoadBalancerPingClassName");
        classToProperty.put(IRule.class, "NFLoadBalancerRuleClassName");
        classToProperty.put(ServerList.class, "NIWSServerListClassName");
        classToProperty.put(ServerListFilter.class, "NIWSServerListFilterClassName");
    }

    /**
     * 重写 支持 ribbon.NFLoadBalancerRuleClassName=package.YourRule 全局配置的方式
     */
    @Override
    public String getClassName(Class clazz, String name) {
        String className = super.getClassName(clazz, name);
        // 读取全局配置
        if(!StringUtils.hasText(className) && this.classToProperty.containsKey(clazz)){
            String classNameProperty = this.classToProperty.get(clazz);
            className = environment.getProperty(NAMESPACE + "." + classNameProperty);
        }
        return className;
    }

}
