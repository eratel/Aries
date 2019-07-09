package com.github.eratel.intercept;

import com.github.eratel.config.FeignInterceptorConfiguration;
import com.github.eratel.constant.AriesConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AriesRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(AriesConstant.STRATEGYVERSION, FeignInterceptorConfiguration.CONTEXT.get());
    }
}
