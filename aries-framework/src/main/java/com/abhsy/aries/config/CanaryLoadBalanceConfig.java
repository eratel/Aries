package com.abhsy.aries.config;

import com.abhsy.aries.intercept.ZonAvoidanceWithMetadataRule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(RibbonClientConfiguration.class)
public class CanaryLoadBalanceConfig {

    @Bean
    public IRule ribbonRule(IClientConfig config, ServerIntrospector serverIntrospector) {
        ZonAvoidanceWithMetadataRule rule = new ZonAvoidanceWithMetadataRule();
        rule.initWithNiwsConfig(config);
        rule.setServerIntrospector(serverIntrospector);
        return rule;
    }
}
