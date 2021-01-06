package com.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//@ComponentScan({ "com.doctor.remittance" })
//@EntityScan("com.doctor.model")
public class DoctorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorDemoApplication.class, args);
	}

}
