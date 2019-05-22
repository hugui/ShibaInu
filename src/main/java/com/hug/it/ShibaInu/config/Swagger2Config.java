package com.hug.it.ShibaInu.config;

import com.hug.it.ShibaInu.annotations.ActivityApiOperation;
import com.hug.it.ShibaInu.annotations.MyApi;
import com.hug.it.ShibaInu.annotations.MyApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 */
@SuppressWarnings({"unused"})
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean("所有模块")
    public Docket allApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ALL")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/*.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

    @Bean("我的模块")
    public Docket myApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("我的模块")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(MyApiOperation.class))
                .paths(PathSelectors.regex("/*.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }
    @Bean("活动模块")
    public Docket activityApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("活动模块")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ActivityApiOperation.class))
                .paths(PathSelectors.regex("/*.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXXXX系统平台接口文档")
                .description("提供子模块1/子模块2/子模块3的文档")
                .termsOfServiceUrl("https://xingtian.github.io/trace.github.io/")
                .version("1.0")
                .build();
    }
}