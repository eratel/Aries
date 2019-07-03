package com.abhsy.aries.intercept;

import com.abhsy.aries.config.FeignInterceptorConfiguration;
import com.abhsy.aries.constant.AriesConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AriesRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(AriesConstant.STRATEGYVERSION, FeignInterceptorConfiguration.CONTEXT.get());
    }
}
