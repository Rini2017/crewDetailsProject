package com.api.crew.aso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-09T07:58:16.858Z")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Crew Covid Incident App")
            .description("Shows Crew details")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", ""))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.api.crew.aso"))
                    .build()           
                .apiInfo(apiInfo());
    }
    
 /*// Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
    // Match all paths except /error
        return Predicates.and(
        PathSelectors.regex("/customer.*"),
        Predicates.not(PathSelectors.regex("/error.*"))
        ;
        }*/

}
