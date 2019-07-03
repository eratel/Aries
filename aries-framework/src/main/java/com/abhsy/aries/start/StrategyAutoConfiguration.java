package com.abhsy.aries.start;

import com.abhsy.aries.config.CanaryLoadBalanceConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClients(defaultConfiguration = {CanaryLoadBalanceConfig.class})
public class StrategyAutoConfiguration {

}