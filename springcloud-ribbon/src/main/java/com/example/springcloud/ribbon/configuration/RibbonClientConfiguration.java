package com.example.springcloud.ribbon.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *   Ribbon Clients configuration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/07/29 14:22  修改内容:
 * </pre>
 */
@Configuration(proxyBeanMethods = false)
@ExcludeFromComponentScan
public class RibbonClientConfiguration {

//    @Autowired
//    IClientConfig config;

    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

//    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        return new DefaultRibbonClients.BazServiceList(config);
    }

    @Bean
    public ZonePreferenceServerListFilter serverListFilter() {
        ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
        filter.setZone("myTestZone");
        return filter;
    }
}
