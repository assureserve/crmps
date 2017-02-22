package com.crmps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching

@EnableAutoConfiguration
@ComponentScan
public class CrmpsApplication {
	

	

	public static void main(String[] args) {
		SpringApplication.run(CrmpsApplication.class, args);
	}
}
