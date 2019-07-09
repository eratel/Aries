package com.github.eratel.config;

import com.github.eratel.constant.AriesConstant;
import com.github.eratel.intercept.AriesRequestInterceptor;
import com.github.eratel.intercept.HostnameInterceptor;
import com.alibaba.ttl.TransmittableThreadLocal;
import feign.RequestInterceptor;
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
