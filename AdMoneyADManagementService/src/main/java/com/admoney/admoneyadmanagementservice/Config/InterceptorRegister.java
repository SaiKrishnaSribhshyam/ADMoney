package com.admoney.admoneyadmanagementservice.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InterceptorRegister implements WebMvcConfigurer {
    private Logger logger= LoggerFactory.getLogger(InterceptorRegister.class);
    @Autowired
    private AuthenticationInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor).addPathPatterns("/**");
        logger.info("Interceptor registered successfully");
    }
}
