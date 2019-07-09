package com.github.eratel.zuul;

import com.github.eratel.config.FeignInterceptorConfiguration;
import com.github.eratel.constant.AriesConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class StrategyZuulFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        String strategyNowVersion = RequestContext.getCurrentContext().getRequest().getHeader(AriesConstant.STRATEGYVERSION);
        if (strategyNowVersion == null) {
            strategyNowVersion = AriesConstant.ALLSERVER;
        }
        FeignInterceptorConfiguration.CONTEXT.set(strategyNowVersion);
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
