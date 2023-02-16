package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
* 	Si muevo este archivo a alguna carpeta en especifico, debería utilizar las siguientes anotaciones:
*
* 	@SpringBootApplication(scanBasePackages = {"com.example.demo"})
*	@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
*	@EntityScan(basePackages = {"com.example.demo.entity"})
* */

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
