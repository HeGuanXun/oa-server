package com.hgx.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class Swagger2Config {

    private final String projectName = "OA系统";

    //是否开启swagger，正式环境一般是需要关闭的
    @Value("${swagger.enabled}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 指定api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
                .select()
                // 指定Service上的RestController注解
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // 所有controller
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title(projectName+"API")
                //文档描述
                .description("专为"+projectName+"提供精准的api接口")
                //服务条款URL
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                //版本号
                .version("1.0。0")
                .contact(new Contact(projectName, "http://127.0.0.1:8080/","751762100@QQ.COM"))
                .build();
    }

}
