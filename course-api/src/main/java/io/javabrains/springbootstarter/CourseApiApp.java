/**
 * 
 */
package io.javabrains.springbootstarter;

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

/**
 * @author Sahil Rana
 *
 */

@SpringBootApplication
@EnableSwagger2
public class CourseApiApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Set up default configuration
		 * Starts Spring application context
		 * Perform class path scan
		 * Starts Tomcat server
		 */
		SpringApplication.run(CourseApiApp.class, args);

	}
		@Bean
		public Docket swaggerConfiguration(){
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage(("io.javabrains")))
					.build()
					.apiInfo(apiDetails());
		}

		private ApiInfo apiDetails(){
			return new ApiInfo(
					"Course Api",
					"Course Api details",
					"1.0",
					"Free to use",
					new springfox.documentation.service.Contact("Sahil Rana","http://javabrains.io", "sahil.rana@tcs.com"),
					"",
					"",
					Collections.emptyList());
		}
}
