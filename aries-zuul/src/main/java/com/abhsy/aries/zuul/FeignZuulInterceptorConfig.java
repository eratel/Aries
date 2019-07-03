package com.abhsy.aries.zuul;

import com.abhsy.aries.config.AriesRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

public class FeignZuulInterceptorConfig {


    @Bean
    @ConditionalOnBean(RequestInterceptor.class)
    public RequestInterceptor headerInterceptor() {
        return new AriesRequestInterceptor();
    }


    @Bean
    public CanaryZuulFilter canaryZuulFilter() {
        return new CanaryZuulFilter();
    }

}
