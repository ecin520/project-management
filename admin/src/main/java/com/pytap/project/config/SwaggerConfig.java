package com.pytap.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ecin520
 * @date 2020/3/29 23:46
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Ecin520")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pytap"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Ecin520", "http://www.pytap.com", "15607942340@163.com");
        return new ApiInfoBuilder()
                .title("Api Documentation")
                .description("Edited by Ecin520")
                .contact(contact)
                .version("1.0")
                .build();
    }

}
