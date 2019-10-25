package com.litbo.hospital;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/globel/")
                .addResourceLocations("classpath:/phantomjs/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/zdhtml/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/emp/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/templates/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/logo/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/eq/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/cs/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/tmp/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/wjxz/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/downloadFile/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/spEqEmployee/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/bzps/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/tj/");
       ;
    }
}
