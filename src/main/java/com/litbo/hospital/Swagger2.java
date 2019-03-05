package com.litbo.hospital;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        // 为swagger添加header参数可供输入
        ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        userTokenHeader.name("headerUserToken").description("userToken")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        userIdHeader.name("headerUserId").description("userId")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()

                // 添加自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.litbo.hospital.security"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(pars);
    }

    /**
     * Description: 构建 api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("医院设备管理系统后端api接口文档")
                // 设置联系人
                .contact(new Contact("", "", ""))
                // 描述
                .description("")
                // 定义版本号
                .version("1.0").build();
    }

}
