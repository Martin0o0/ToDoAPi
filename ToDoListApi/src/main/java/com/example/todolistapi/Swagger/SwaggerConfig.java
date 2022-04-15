package com.example.todolistapi.Swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //빈 등록
@EnableSwagger2
public class SwaggerConfig{



    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // false로 설정하면 기본 응답 코드를 노출하지 않음!
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.todolistapi.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() { //노출할 정보
        return new ApiInfoBuilder()
                .title("ToDoListApi Swagger")
                .description("swagger config")
                .version("1.0")
                .build();
    }

}
