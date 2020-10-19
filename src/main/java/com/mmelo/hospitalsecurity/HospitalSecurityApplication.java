package com.mmelo.hospitalsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HospitalSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSecurityApplication.class, args);
	}

}
