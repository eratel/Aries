package com.abhsy.aries.config;

import com.abhsy.aries.intercept.ZonAvoidanceWithMetadataRule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.context.annotation.Bean;

public class CanaryLoadBalanceConfig {

    @Bean
    public IRule ribbonRule(IClientConfig config, ServerIntrospector serverIntrospector) {
        ZonAvoidanceWithMetadataRule rule = new ZonAvoidanceWithMetadataRule();
        rule.initWithNiwsConfig(config);
        rule.setServerIntrospector(serverIntrospector);
        return rule;
    }
}
