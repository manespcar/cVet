package com.spain.cvet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.spain.cvet.configuration.JpaConfiguration;

@Import({JpaConfiguration.class})
@SpringBootApplication(scanBasePackages = { "com.spain.cvet" })
public class CVetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CVetApplication.class, args);
	}
}
