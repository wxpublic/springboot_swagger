package com.itmayiedu.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-30 上午 10:28
 */
@Configuration
@EnableSwagger2 //开启Swagger功能
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 指定api扫包范围
                .apis(RequestHandlerSelectors.basePackage("com.itmayiedu.api")).paths(PathSelectors.any()).build();
    }

    //创建API文档信息
    private ApiInfo apiInfo() {
        //title：文档标题  description: 文档描述
        return new ApiInfoBuilder().title("蚂蚁课堂|Swagger案例 微服务接口生成器").description("蚂蚁课堂|Swagger案例 Java分布式&微服务培训")
                .termsOfServiceUrl("http://www.itmayiedu.com")
                .version("1.0").build();
    }
}
