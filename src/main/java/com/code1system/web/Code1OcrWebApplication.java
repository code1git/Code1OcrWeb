package com.code1system.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Code1OcrWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Code1OcrWebApplication.class, args);
	}

}
