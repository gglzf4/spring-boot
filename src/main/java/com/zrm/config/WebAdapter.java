package com.zrm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义自己的web静态页面位置
 * 
 * @author dillion
 * @version $Id: SolarWebMvcConfig.java, v 0.1 2015年3月13日 下午7:31:23 dillion Exp $
 */
@Configuration
public class WebAdapter extends WebMvcConfigurerAdapter {

    private String staticResourcePath = null;

    private HandlerInterceptor handlerInterceptor;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if(staticResourcePath != null){
            registry.addResourceHandler("/js/**", "/css/**", "/image/**", "/images/**", "/upload/**",
                    "/music/**").addResourceLocations(
                    //FE JS
                    staticResourcePath + "/js/",
                    //FE CSS 样式
                    staticResourcePath + "/css/",
                    //FE图片资源
                    staticResourcePath + "/image/",
                    //FE图片资源
                    staticResourcePath + "/images/",
                    //各类上传图片资源
                    staticResourcePath + "/upload/",
                    //
                    staticResourcePath + "/music/");
        }


    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setWriteAcceptCharset(false);
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(list);
        converters.add(converter);

        MappingJackson2HttpMessageConverter jsonConvert = new MappingJackson2HttpMessageConverter();
        jsonConvert.setSupportedMediaTypes(list);
        converters.add(jsonConvert);

        super.configureMessageConverters(converters);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        if (handlerInterceptor != null) {
            registry.addInterceptor(handlerInterceptor);
        }

    }
}
