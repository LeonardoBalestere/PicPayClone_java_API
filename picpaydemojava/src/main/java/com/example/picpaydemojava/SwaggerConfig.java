package com.example.picpaydemojava;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${spring.api.version}")
	private String versionAPI;
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.picpaydemojava")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.securitySchemes(Arrays.asList(apiKey()));

	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("PicPayClone API")
				.description("API RestFull structure with Spring Boot to be like PicPay")
				.version(versionAPI).build();
	}
	
	private ApiKey apiKey() {
	    return new ApiKey("Authorization", "Authorization", "header");
	}
}
