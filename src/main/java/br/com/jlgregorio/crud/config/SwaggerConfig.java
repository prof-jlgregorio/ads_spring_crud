package br.com.jlgregorio.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.jlgregorio.crud"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My CRUD API",
                "A simple REST API made with Spring",
                "1.0",
                "http://www.jlgregorio.com.br",
                new Contact("Prof. Jorge L. Gregório", "http://www.jlgregorio.com.br",
                        "jorge.gregorio@fatec.sp.gov.br"),
                "MIT License", "http://www.jlgregorio.com.br",
                Collections.emptyList());
    }

}
