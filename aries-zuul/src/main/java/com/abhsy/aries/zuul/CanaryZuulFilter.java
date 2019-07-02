package com.abhsy.aries.zuul;

import com.abhsy.aries.config.FeignInterceptorConfig;
import com.abhsy.aries.constant.AriesConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;

public class CanaryZuulFilter extends ZuulFilter {

    @Value("${eureka.metadataMap.canaryVersion:all}")
    private String defaultVersion = null;

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String canryVersion = RequestContext.getCurrentContext().getRequest().getHeader(AriesConstant.TOKENHEADER);
        if (canryVersion == null) {
            canryVersion = defaultVersion;
        }
        FeignInterceptorConfig.CONTEXT.set(canryVersion);
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
