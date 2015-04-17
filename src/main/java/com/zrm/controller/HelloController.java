package com.zrm.controller;

import com.zrm.component.interceptor.UnAccessTokenInterceptor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 201503105229 on 2015/4/9.
 */
@RestController
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/")
    @UnAccessTokenInterceptor
    String good(HttpServletResponse response){
        Map<String,String> m = new HashMap<String, String>();

        String s = "好好学习1";
        m.put("key",s);

        logger.info(s);
        return m.toString();
    }

}
