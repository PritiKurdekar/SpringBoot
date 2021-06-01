package com.cg.apps.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProductmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmsApplication.class, args);
	}

	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.apps.productms")).paths(PathSelectors.any()).build();
		return docket;
	}

	@Bean
	public ApiInfo apiInfo() {
		ApiInfo info = new ApiInfoBuilder().title("Product management application")
				.description("rest api for product management").build();
		return info;
	}

}
