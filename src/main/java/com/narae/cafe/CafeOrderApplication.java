package com.narae.cafe;

import com.narae.cafe.user.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CafeOrderApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CafeOrderApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CafeOrderApplication.class, args);
	}
}
