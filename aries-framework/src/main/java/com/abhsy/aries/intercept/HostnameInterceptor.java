package com.abhsy.aries.intercept;

import com.abhsy.aries.config.FeignInterceptorConfig;
import com.abhsy.aries.constant.AriesConstant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HostnameInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截请求
        String hostname = request.getHeader(AriesConstant.STRATEGYVERSION);
        if (hostname == null)
        {
            hostname = AriesConstant.ALLSERVER;
        }
        //存放到localhost中
        FeignInterceptorConfig.CONTEXT.set(hostname);
        return true;
    }
}
