package com.ys.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title swaggerConfig
 * @date 2020/2/26 10:33
 */
@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket platformApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("YS-API").description("©2020-2-26 Copyright. Powered By YS.")
                // .termsOfServiceUrl("")
                .contact(new Contact("Ys", "https://www.baidu.com", "ys532636429@163.com")).license("Apache License Version 2.0")
                .licenseUrl("").version("2.0").build();
    }

}