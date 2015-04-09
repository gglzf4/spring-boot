package com.zrm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 201503105229 on 2015/4/9.
 */
@RestController
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/",produces = {"application/json"})
    String good(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        String s = "好好学习";
        logger.info(s);
        return s;
    }

}
