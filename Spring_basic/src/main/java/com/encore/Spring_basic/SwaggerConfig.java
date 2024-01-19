package com.encore.Spring_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
    Docket : Swagger 구성의 핵심 기능 클래스
     */
    @Bean
    public Docket api(){
        // http://localhost:8080/swagger-ui/#/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()   // 어떤 컨트롤러 또는 어떤 api를 Swagger 문서에 포함시킬지 선택메
                .apis(RequestHandlerSelectors.any()) // 모든 RequestHandlerSelectors 들을 문서화 대상으로 선택한다는 설정
//                .paths(PathSelectors.any()) 모든 패스의 컨트롤러에 Swagger 적용
                .paths(PathSelectors.ant("/rest/**"))
                .build();
        /*
         Swagger 의 authorize 자물쇠 버튼 활성화를 위해서는
         jwt, session 등의 별도의 설정 필요
         */
        
    }

}
