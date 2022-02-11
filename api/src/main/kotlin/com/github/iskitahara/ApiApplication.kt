package com.github.iskitahara

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseBuilder
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.time.LocalDate


@EnableSwagger2
@ConfigurationPropertiesScan(basePackages = ["com.github.iskitahara", "com.github.iskitahara.controller"])
@SpringBootApplication(scanBasePackages = ["com.github.iskitahara", "com.github.iskitahara.controller"])
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}

@Bean
fun petApi(): Docket? {
	return Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.any())
		.paths(PathSelectors.any())
		.build()
		.pathMapping("/")
		.directModelSubstitute(LocalDate::class.java, String::class.java)
		.genericModelSubstitutes(ResponseEntity::class.java)
		.useDefaultResponseMessages(false)
		.globalResponses(
			HttpMethod.GET,
			listOf(ResponseBuilder()
				.code("500")
				.description("500 message")
				.representation(MediaType.TEXT_XML)
				.apply { r ->
					r.model { m ->
						m.referenceModel { ref ->
							ref.key { k ->
								k.qualifiedModelName { q ->
									q.namespace("some:namespace")
										.name("ERROR")
								}
							}
						}
					}
				}
				.build()))
		.tags(Tag("Order Service", "All apis relating to pets"))
}