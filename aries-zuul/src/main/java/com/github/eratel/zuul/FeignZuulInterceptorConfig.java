package com.github.eratel.zuul;

import com.github.eratel.intercept.AriesRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

public class FeignZuulInterceptorConfig {


    @Bean
    @ConditionalOnBean(AriesRequestInterceptor.class)
    public RequestInterceptor headerInterceptor() {
        return new AriesRequestInterceptor();
    }


    @Bean
    public StrategyZuulFilter canaryZuulFilter() {
        return new StrategyZuulFilter();
    }

}
