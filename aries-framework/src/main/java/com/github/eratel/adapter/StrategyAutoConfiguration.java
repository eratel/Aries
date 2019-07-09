package com.github.eratel.adapter;

import com.github.eratel.config.CanaryLoadBalanceConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(defaultConfiguration = {CanaryLoadBalanceConfiguration.class})
public class StrategyAutoConfiguration {

}