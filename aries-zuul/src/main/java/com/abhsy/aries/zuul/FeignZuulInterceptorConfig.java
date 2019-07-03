package com.abhsy.aries.zuul;

import com.abhsy.aries.config.FeignInterceptorConfig;
import com.abhsy.aries.constant.AriesConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FeignZuulInterceptorConfig
{
	@Bean
	public RequestInterceptor headerInterceptor()
	{
		return new RequestInterceptor() 
		{
			@Override
			public void apply(RequestTemplate restTemplate) 
			{
				restTemplate.header(AriesConstant.TOKENHEADER, FeignInterceptorConfig.CONTEXT.get());
			}
		};
	}

	
	@Bean  
    public CanaryZuulFilter canaryZuulFilter() {  
        return new CanaryZuulFilter();  
    }
	
}
