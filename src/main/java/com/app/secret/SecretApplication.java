package com.app.secret;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@MapperScan("com.app.secret.mapper")
@ComponentScan
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
public class SecretApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretApplication.class, args);
	}

}

