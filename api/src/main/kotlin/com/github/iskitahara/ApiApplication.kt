package com.github.iskitahara

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan(basePackages = ["com.github.iskitahara", "com.github.iskitahara.controller"])
@SpringBootApplication(scanBasePackages = ["com.github.iskitahara", "com.github.iskitahara.controller"])
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
