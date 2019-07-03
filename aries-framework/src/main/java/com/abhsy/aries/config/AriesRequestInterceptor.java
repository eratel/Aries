package com.abhsy.aries.config;

import com.abhsy.aries.constant.AriesConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AriesRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(AriesConstant.STRATEGYVERSION, FeignInterceptorConfig.CONTEXT.get());
    }
}
