package com.litbo.hospital;

import com.litbo.hospital.common.utils.GetProjectAddressUtil;
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
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/logo/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/eq/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/tmp/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/downloadFile/");
        System.out.println(GetProjectAddressUtil.getAddress());

}
}
