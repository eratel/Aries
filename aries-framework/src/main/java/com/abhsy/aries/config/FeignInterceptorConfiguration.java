package com.abhsy.aries.config;

import com.abhsy.aries.constant.AriesConstant;
import com.abhsy.aries.intercept.AriesRequestInterceptor;
import com.abhsy.aries.intercept.HostnameInterceptor;
import com.alibaba.ttl.TransmittableThreadLocal;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class FeignInterceptorConfiguration implements WebMvcConfigurer {

    public static final TransmittableThreadLocal<String> CONTEXT = new TransmittableThreadLocal<>();

    @Bean
    public RequestInterceptor headerInterceptor() {
        return new AriesRequestInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HostnameInterceptor()).addPathPatterns(AriesConstant.CONTEXTPATH);
    }
}
