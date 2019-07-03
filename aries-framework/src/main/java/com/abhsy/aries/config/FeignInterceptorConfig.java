package com.abhsy.aries.config;

import com.abhsy.aries.constant.AriesConstant;
import com.abhsy.aries.intercept.HostnameInterceptor;
import com.alibaba.ttl.TransmittableThreadLocal;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FeignInterceptorConfig implements WebMvcConfigurer {

    public static final TransmittableThreadLocal<String> CONTEXT = new TransmittableThreadLocal<>();

    @Bean
    public RequestInterceptor headerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate restTemplate) {
                restTemplate.header(AriesConstant.TOKENHEADER, CONTEXT.get());
            }
        };
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HostnameInterceptor()).addPathPatterns(AriesConstant.CONTEXTPATH);
    }
}
