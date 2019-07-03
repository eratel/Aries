package com.abhsy.aries.zuul;

import com.abhsy.aries.config.FeignInterceptorConfiguration;
import com.abhsy.aries.constant.AriesConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;

public class CanaryZuulFilter extends ZuulFilter {

    @Value("${eureka.metadataMap.strategyVersion:all}")
    private String strategyVersion = null;

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String strategyNowVersion = RequestContext.getCurrentContext().getRequest().getHeader(AriesConstant.STRATEGYVERSION);
        if (strategyVersion == null) {
            strategyVersion = strategyNowVersion;
        }
        FeignInterceptorConfiguration.CONTEXT.set(strategyVersion);
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
