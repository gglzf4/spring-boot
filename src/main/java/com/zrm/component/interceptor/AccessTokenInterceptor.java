package com.zrm.component.interceptor;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * 处理返回数据拦截器。此拦截器的目的为将javabean序列化成json，然后返回给client端
 * TODO 更好的方法是拿到modelandview后，用自定义的view生成器生成json然后返回，不过嘛，目前对spring还不是特熟悉，暂时这么着吧
 */
@Component("accessTokenInterceptor")
public class AccessTokenInterceptor extends AnnotationBasedInterceptor {

    private Logger logger = Logger.getLogger(AccessTokenInterceptor.class);

    public static final String XML_HTTP_HEADER = "XMLHttpRequest";
    public static final String XML_HTTP_HEADER_KEY = "x-requested-with";
    public static final String INDEX_LOGIN_URL ="/index";
    public static final String ADMIN_LOGIN_URL ="/admin";

    @Override
    public Class<? extends Annotation> getInterceptorExclusionAnnotationClass() {
        logger.info("-------------AccessToken getInterceptorExclusionAnnotationClass---------------");
        return UnAccessTokenInterceptor.class;
    }


    @Override
    public boolean before(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getParameter("access_token") == null){
            logger.info("-------------AccessToken before 1---------------");
            request.setAttribute("error","miss access_token1");
            return false;
        }
        return true;
    }

}