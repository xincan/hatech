package cn.com.hatech.app.business.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: ResultCode
 * Author:   JiangXincan
 * Date:     2018-12-19 16:30:00
 * @Description: xincan-swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.hatech"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        return new ApiInfoBuilder()
                .description("北京同创永益科技发展有限公司 同创云应用资源池API(APP-CORE-API)")
                .license("xincan.1.0")
                .licenseUrl("https://github.com/xincan/xincan-api-ui-layer")
                .title("北京同创永益科技发展有限公司 APP-CORE-API")
                .description("开发人员内部文档")
                .termsOfServiceUrl("alittlexincan@163.com")
                .contact(new Contact("JiangxXincan", "https://github.com/xincan/xincan-api-ui-layer", "alittlexincan@163.com"))
                .version("1.0")
                .build();
    }
}