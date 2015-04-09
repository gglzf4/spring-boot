package com.zrm;

/**
 * Created by 201503105229 on 2015/4/1.
 */
import com.zrm.config.WebAdapter;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 *   http://www.infoq.com/cn/news/2014/01/spring-boot/
 *
 * */
@SpringBootApplication
@ImportResource({ "classpath*:/META-INF/spring/*.xml", "classpath*:/MVC-INF/*.xml" })
public class Application extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public WebMvcConfigurerAdapter getWebAdapter(){
        return new WebAdapter();
    }




    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}
