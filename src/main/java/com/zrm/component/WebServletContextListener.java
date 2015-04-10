package com.zrm.component;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 201503105229 on 2015/4/9.
 */
@Component
public class WebServletContextListener implements ServletContextListener {
    Logger logger = Logger.getLogger(WebServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("-------------contextInitialized--------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("-------------contextDestroyed--------------");
    }
}
