package jack.swagger;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/contact/*")) // limit the end points by path
				.apis(RequestHandlerSelectors.basePackage("jack.swagger")) // limit the end points by its basepackages
				.build()
				.apiInfo(getAPIInfo())
				;
	}

	private ApiInfo getAPIInfo() {
		return new ApiInfo(
					"Title: AddressBook API", 
					"Description: An API that records contact information, including id, name and phone-number", 
					"Version: 1.0", 
					"termsOfServiceUrl: free to use", 
					new springfox.documentation.service.Contact("Jack", "Url unavailabe", "someone@somewhere.com"), 
					"Lisence: none", 
					"Lisence url: none", 
					Collections.emptyList());
	}
}
